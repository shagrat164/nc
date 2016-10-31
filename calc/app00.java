
public class app00 {

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

}

class A {
    private static int find(String expr) {
        int num = 0;
        int ans = -1;
        for (int i=0; i<expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') {
                num++;
            }
            if (c == ')') {
                num--;
            }
            if ((c == '+' || c == '-' || c == '*' || c == '%' || c == '/') && num == 1) {
                ans = i;
            }
        }
        return ans;
    }

    private static int chrToInt(char c1, char c2, char c3) {//calculate expression
        int n1 = c1 - '0';
        int n2 = c2 - '0';
        if (c3 == '+') {
            return n1 + n2;
        } else if (c3 == '-') {
            return n1 - n2;
        } else if (c3 == '%') {
            return n1 % n2;
        } else if (c3 == '/') {
            return n1 / n2;
        }
        return n1 * n2;
    }

    private static int evalExpr1(String expr){
        int a=find(expr);
        char c1, c2, c3;
        if (a == -1) {//if string contains from 1 char
            int n = Integer.parseInt(expr);
            return n;
        }
        if (expr.length() == 5) {//if string contains from light expression (x+y)
            //c1 left num,c2 right num,c3 +,-,%,*
            c1 = expr.charAt(1);
            c2 = expr.charAt(3);
            c3 = expr.charAt(2);
            return chrToInt(c1, c2, c3);
        }
        String s1 = expr.substring(1, a);
        String s2 = expr.substring(a + 1, expr.length() - 1);
        c1 = expr.charAt(a);
        if (c1 == '-') {
            return evalExpr1(s1) - evalExpr1(s2);
        }
        if (c1 == '%') {
            return evalExpr1(s1) % evalExpr1(s2);
        }
        if (c1 == '/') {
            return evalExpr1(s1) / evalExpr1(s2);
        }
        if (c1 == '*') {
            return evalExpr1(s1) * evalExpr1(s2);
        }
        return evalExpr1(s1) + evalExpr1(s2);
    }

    private static boolean isLegalExp(String expr){
        int a = find(expr);
        if (a == -1) {
            return true;
        }
        String s1 = expr.substring(1, a);
        String s2 = expr.substring(a + 1, expr.length() - 1);
        return isLegalExp(s1) && isLegalExp(s2);
    }

    public static String evalExpr2(String expr){
        if (isLegalExp(expr)) {
            int n=evalExpr1(expr);
            return String.valueOf(n);
        }
        return "error";
    }

}