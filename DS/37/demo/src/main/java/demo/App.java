package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

class App {
    public static void main(String[] args) {
        // var secret = "lakes revocation spoils exhaust";
        // var view = "----- ---------- ------ -------";
        var secret = "lakes";
        var view = "-----";
        var words = readWords().toList();

        var len = view.length();
        for (var ww : words) {
            if (ww.length() == len) {
                System.out.println(ww);
            }
        }
    }

    static Stream<String> readWords() {
        InputStream raw = App.class
            .getResourceAsStream("/words.txt.gz");
        // InputStream gives us two methods we care about:
        //   read() -> one byte
        //   read(array) -> fills array with bytes
        GZIPInputStream unz = new GZIPInputStream(raw);
        InputStreamReader rdr = new InputStreamReader(unz);
        BufferedReader buf = new BufferedReader(rdr);
        return buf.lines();
    }
}
