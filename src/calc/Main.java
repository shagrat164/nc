// Разбор арифметического выражения (Алгоритм парсинга арифметических выражений, Обратная польская запись)
// http://algolist.ru/syntax/parsear.php

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String pattern = "^[\\d\\+\\/\\*\\.\\- \\(\\)]*$";
//        String pattern = "^\\(\\d+[\\+\\-\\*\\/]\\d\\)$";
        /*if (checkExpr("(543+)")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }*/
        //A a = new A();
        System.out.println(removeTheBrackets("(67+76)"));
    }

    /**
     * Метод проверяет входное выражение на соответствие
     * виду (xYx) , где х - число, Y - знак операции
     *
     * @param expr Входное выражение для проверки на соответствие
     * @return true - выражение соответствует
     *         false - выражение не соответствует
     */
    private static boolean checkExpr (String expr) {
        boolean result = false;
        Pattern pattern = Pattern.compile("^\\(\\d+[\\+\\-\\*\\/]\\d\\)$");
        Matcher matcher = pattern.matcher(expr);
        if (matcher.matches()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    private int calculate(String expr) {
        int result = 0;
        int pos = 0;

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
                pos = i;
                break;
            }
        }
        char sign = expr.charAt(pos);
        return result;
    }

    /**
     * Удаление скобок из выражения
     * @param expr входное выражение
     * @return Отформатированную строку без скобок
     */
    private static String removeTheBrackets(String expr) {
        String result = "";
        char[] ch = expr.toCharArray();
        for (int i = 0; i < ch.length; i++) {
//            if (ch[i] != '(' || ch[i] != ')') {
//                result += ch[i];
//            }
        }
        return result;
    }
}
