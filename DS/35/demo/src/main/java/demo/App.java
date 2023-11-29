package demo;

import java.io.Console;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public class App {
    public static void main(String[] args) {
        var menu = new HashMap<String, MenuItem>();
        for (var line : readMenuLines()) {
            var parts = line.split("\t");
            var code = parts[0];
            var name = parts[1];
            var price = parts[2];
            var item = new MenuItem(code, name, priceToCents(price));
            menu.put(code, item);
        }

        var con = System.console();

        while (true) {
            var orderText = con.readLine("order> ");
            var itemCodes = orderText.split("\\W");

            var receiptLines = new HashMap<String, ReceiptLine>();
            for (var code : itemCodes) {
                var item = menu.get(code);
                if (receiptLines.containsKey(item.name())) {
                    var line0 = receiptLines.get(item.name());
                    var line1 = new ReceiptLine(item, line0.count() + 1);
                    receiptLines.put(item.name(), line1);
                }
                else {
                    var line = new ReceiptLine(item, 1);
                    receiptLines.put(item.name(), line);
                }
            }

            var receipt = new Receipt(receiptLines.values().stream().toList());
            con.printf(receipt.toString());
        }
    }

    static int priceToCents(String price) {
        var parts = price.split("\\.");
        return 100 * Integer.parseInt(parts[0]) +
            Integer.parseInt(parts[1]);
    }

    static List<String> readMenuLines() {
        InputStream txt = App.class
            .getResourceAsStream("/menu.tsv");
        InputStreamReader rdr = new InputStreamReader(txt);
        BufferedReader buf = new BufferedReader(rdr);
        return buf.lines().toList();
    }
}

record MenuItem(String code, String name, int cents) {
    String price() {
        return PH.toDollars(cents);
    }
}

record Receipt(List<ReceiptLine> lines) {
    private int subtotalCents() {
        int cents = 0;
        for (var line : lines) {
            cents += line.item().cents() * line.count();
        }
        return cents;
    }

    String subtotal() {
        return PH.toDollars(subtotalCents());
    }

    private int taxCents() {
        return (int) Math.round(0.0625 * subtotalCents());
    }

    String tax() {
        return PH.toDollars(taxCents());
    }

    private int totalCents() {
        return subtotalCents() + taxCents();
    }

    String total() {
        return PH.toDollars(totalCents());
    }

    @Override
    public String toString() {
        var yy = new StringBuilder();
        yy.append(" == Your Receipt == \n");
        for (var line : lines) {
            yy.append(line.toString());
        }
        yy.append(String.format("subtotal:\t\t%s\n", subtotal()));
        yy.append(String.format("tax:\t\t%s\n", tax()));
        yy.append(String.format("total:\t\t%s\n", total()));
        return yy.toString();
    }
}

record ReceiptLine(MenuItem item, int count) {
    int totalCents() {
        return item.cents() * count;
    }

    String total() {
        return PH.toDollars(totalCents());
    }

    @Override
    public String toString() {
        return String.format("%s\t\t%s\t%d\t%s\n",
                             item.name(), item.price(), count(), total());
    }
}

class PH {
    static String toDollars(int cents) {
        long dollars = cents / 100;
        long frac = Math.floorMod(cents, 100);
        return "$" + dollars + "." + frac;
    }
}

/*
A receipt is several lines, each one has:
    - A menu item
    - Count ordered
    - Calculate a total
Additionally:
    - Subtotal
    - Tax
    - Total
*/



    

