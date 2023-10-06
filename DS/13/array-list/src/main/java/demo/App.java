package demo;

import java.util.Stack;

class App1 {
    static void foo(short xx) {
        System.out.println("short");
    }
    
    static void foo(long xx) {
        System.out.println("long");
    }
}

public class App {
    public static void main(String[] args) {
        String[] expr = {
            "35", "29", "14", "+", "*"
        };
        String infix = postfixToInfix(expr);
        System.out.println(infix);
    }

    static String postfixToInfix(String[] toks) {
        var st = new Stack<String>();

        for (int ii = 0; ii < toks.length; ++ii) {
            String tt = toks[ii];
            if (isOperator(tt)) {
                var a1 = st.pop();
                var a2 = st.pop();
                st.push("(" + a1 + tt + a2 + ")");
            }
            else {
                st.push(tt);
            }
        }

        return st.pop();
    }

    static boolean isOperator(String xx) {
        return xx.equals("+") || xx.equals("-")
                || xx.equals("*") || xx.equals("/");
    }
}

class App4 {
    public static void main(String[] args) {
        int[] xs = {1, 2, 3, 4, 5};
        int[] ys = reverse(xs); 

        for (int ii = 0; ii < ys.length; ++ii) {
            System.out.println(ys[ii]);
        }
    }

    static int[] reverse(int[] xs) {
        var st = new Stack<Integer>();

        for (int ii = 0; ii < xs.length; ++ii) {
            st.push(xs[ii]);
        }

        int[] ys = new int[xs.length];        

        int ii = 0;
        while (!st.empty()) {
            ys[ii] = st.pop();
            ++ii;
        }

        return ys;
    }
}





class Goat {
    final String name;

    Goat(int xx) {
        this("Bob" + xx);
    }

    Goat(String name) {
        this.name = name;
    }

    Goat() {
        this(4);
    }
}


