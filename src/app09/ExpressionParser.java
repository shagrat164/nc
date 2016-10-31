package app09;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by danila on 29.10.2016.
 */

class ExpressionParser {
    private String operators = "+-*/%";
    private String delimiters = "() " + operators;
    private boolean flag = true;

    /**
     *
     * @param token
     * @return
     */
    private boolean isDelimiter(String token) {
        if (token.length() != 1) {
            return false;
        }
        for (int i = 0; i < delimiters.length(); i++) {
            if (token.charAt(0) == delimiters.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param token
     * @return
     */
    private boolean isOperator(String token) {
        if (token.length() != 1) {
            return false;
        }
        if (token.equals("±")) {
            return true;
        }
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param token
     * @return
     */
    private int priority(String token) {
        if (token.equals("(")) {
            return 1;
        }
        if (token.equals("+") || token.equals("-")) {
            return 2;
        }
        if (token.equals("*") || token.equals("/") || token.equals("%")) {
            return 3;
        }
        return 4;
    }

    /**
     * Метод проверяет входное выражение на корректность ввода
     *
     * @param expr Входное выражение для проверки на соответствие
     * @return true - выражение соответствует
     *         false - выражение не соответствует
     */
    private static boolean checkExpr (String expr) {
        boolean result = false;
        String stringPattern = "^[\\d\\+\\/\\*\\.\\- \\(\\)\\%]+$";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(expr);
        if (matcher.matches()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public boolean isFlag() {
        return flag;
    }

    /**
     * Алгоритм [править | править вики-текст]
     * -Пока есть ещё символы для чтения:
     *      -Читаем очередной символ.
     *      -Если символ является числом, добавляем его к выходной строке.
     *        -Если символ является символом функции, помещаем его в стек. (не реализовано)
     *      -Если символ является открывающей скобкой, помещаем его в стек.
     *      -Если символ является закрывающей скобкой:
     *          -До тех пор, пока верхним элементом стека не станет открывающая скобка, выталкиваем элементы из стека в выходную строку.
     *          При этом открывающая скобка удаляется из стека, но в выходную строку не добавляется. Если стек закончился раньше,
     *          чем мы встретили открывающую скобку, это означает, что в выражении либо неверно поставлен разделитель, либо не
     *          согласованы скобки.
     *      -Если символ является оператором о1, тогда:
     *          1) пока…
     *             … (если оператор o1 право-ассоциированный) приоритет o1 меньше приоритета оператора, находящегося на вершине стека…
     *             … (если оператор o1 ассоциированный, либо лево-ассоциированный) приоритет o1 меньше либо равен приоритету оператора,
     *                находящегося на вершине стека…
     *          … выталкиваем верхний элемент стека в выходную строку;
     *          2) помещаем оператор o1 в стек.
     * -Когда входная строка закончилась, выталкиваем все символы из стека в выходную строку. В стеке должны были
     * остаться только символы операторов; если это не так, значит в выражении не согласованы скобки.
     *
     * @param expr
     * @return
     * @throws ParserException
     */
    public List<String> parse(String expr) throws ParserException {
        List<String> result = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();
        StringTokenizer tokenizer = new StringTokenizer(expr, delimiters, true);
        String prev = "";
        String curr = "";
        if (checkExpr(expr) == false) {
            flag = false;
            handleError("Некорректное выражение.");
            return result;
        }
        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (tokenizer.hasMoreTokens() == false && isOperator(curr)) {
                flag = false;
                handleError("Некорректное выражение.");
                return result;
            }
            if (curr.equals(" ")) {
                continue;
            }
            if (isDelimiter(curr)) {
                if (curr.equals("(")) {
                    stack.push(curr);
                } else if (curr.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        result.add(stack.pop());
                        if (stack.isEmpty()) {
                            flag = false;
                            handleError("Скобки не согласованы.");
                            return result;
                        }
                    }
                    stack.pop();
                } else {
                    if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev)  && !prev.equals(")")))) {
                        curr = "±";
                    } else {
                        while (stack.isEmpty() == false && (priority(curr) <= priority(stack.peek()))) {
                            result.add(stack.pop());
                        }
                    }
                    stack.push(curr);
                }
            } else {
                result.add(curr);
            }
            prev = curr;
        }
        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) {
                result.add(stack.pop());
            } else {
                flag = false;
                handleError("Скобки не согласованы.");
                return result;
            }
        }
        return result;
    }

    private List<String> optimizationExpr (List<String> expr) {
        List<String> result = new ArrayList<String>();

        return result;
    }

    private void handleError (String message) throws ParserException {
        throw new ParserException(message);
    }
}
