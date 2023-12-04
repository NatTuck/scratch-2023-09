package demo;

import java.io.Console;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public class App {
    public static void main(String[] args) throws IOException {
        var con = System.console();

        //var secret = randomPuzzle();
        //var guesses = new HashSet<Integer>();

        var words = readWords();

        while (true) {
            var pattern = con.readLine("pattern> ");

            for (var ww : words) {
                if (match(pattern, ww)) {
                    con.printf("%s\n", ww);
                }
            }
        }
    }

    static boolean match(String pat, String word) {
        final int dash = "-".codePointAt(0);

        // pattern:  --e
        if (pat.length() != word.length()) {
            return false;
        }

        for (int ii = 0; ii < word.length(); ++ii) {
            int aa = pat.codePointAt(ii);
            int bb = word.codePointAt(ii);
            if (aa != bb && aa != dash) {
                return false;
            }
        }

        return true;
    }

    static String puzzleView(List<String> secret, HashSet<Integer> guesses) {
        var yy = new StringBuilder();
        for (var word : secret) {
            for (var ch : word.codePoints().boxed().toList()) {
                if (guesses.contains(ch)) {
                    yy.append(Character.toString(ch));
                }
                else {
                    yy.append("-");
                }
            }
            yy.append(" ");
        }
        return yy.toString();
    }

    static ArrayList<String> randomPuzzle() throws IOException {
        var words = readWords();
        var ys = new ArrayList<String>();
        for (int jj = 0; jj < 5; ++jj) {
            int ii = (int)(words.size() * Math.random());
            ys.add(words.get(ii));
        }
        return ys;
    }

    static List<String> readWords() throws IOException {
        InputStream raw = App.class
            .getResourceAsStream("/words.txt.gz");
        GZIPInputStream unz = new GZIPInputStream(raw);
        InputStreamReader rdr = new InputStreamReader(unz);
        BufferedReader buf = new BufferedReader(rdr);
        return buf.lines().toList();
    }
}
