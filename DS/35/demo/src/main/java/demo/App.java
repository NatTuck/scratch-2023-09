package demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Array;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;

public class App {
    public static void main(String[] args) {
        
    }

    Stream<String> readMenuLines() {
        InputStream txt = App.class
            .getResourceAsStream("/menu.tsv");
        InputStreamReader rdr = new InputStreamReader(txt);
        BufferedReader buf = new BufferedReader(rdr);
        return buf.lines();
    }
}

