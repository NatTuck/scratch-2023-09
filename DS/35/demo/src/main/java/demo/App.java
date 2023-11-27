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
            var items = orderText.split("\\W");
            for (var item: items) {
                con.printf("User picked: %s\n", item);
                con.printf("That's: %s\n", menu.get(item));
            }
        }
    }

    static long priceToCents(String price) {
        var parts = price.split("\\.");
        return 100 * Long.parseLong(parts[0]) +
            Long.parseLong(parts[1]);
    }

    static List<String> readMenuLines() {
        InputStream txt = App.class
            .getResourceAsStream("/menu.tsv");
        InputStreamReader rdr = new InputStreamReader(txt);
        BufferedReader buf = new BufferedReader(rdr);
        return buf.lines().toList();
    }
}

record MenuItem(String code, String name, long cents) {
    String price() {
        long dollars = cents / 100;
        long frac = Math.floorMod(cents, 100);
        return "$" + dollars + "." + frac;
    }
}
