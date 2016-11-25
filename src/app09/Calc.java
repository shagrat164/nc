package app09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

/**
 * Created by danila on 28.10.2016.
 *
 * Обра́тная по́льская нота́ция (ОПН) — форма записи математических и логических выражений,
 * в которой операнды расположены перед знаками операций.
 * Также именуется как обратная польская запись, обратная бесскобочная запись (ОБЗ),
 * постфиксная нотация, бесскобочная символика Лукасевича, польская инверсная запись, ПОЛИЗ.
 *
 */

public class Calc {

    /**
     * 1. Обработка входного символа:
     * - Если на вход подан операнд, он помещается на вершину стека.
     * - Если на вход подан знак операции, то соответствующая операция выполняется над требуемым количеством значений,
     * извлечённых из стека, взятых в порядке добавления. Результат выполненной операции кладётся на вершину стека.
     * 2. После полной обработки входного набора символов результат вычисления выражения лежит на вершине стека.
     *
     * @param postfix
     * @return
     */

    public static Double calc(List<String> postfix) throws NoSuchElementException {
        Deque<Double> stack = new ArrayDeque<Double>();
        for (String x : postfix) {
            if (x.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (x.equals("-")) {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(a - b);
            } else if (x.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (x.equals("/")) {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(b / a);
            } else if (x.equals("%")) {
                Double a = stack.pop();
                Double b = stack.pop();
                stack.push(b % a);
            } else if (x.equals("±")) {
                stack.push(-stack.pop());
            } else {
                stack.push(Double.valueOf(x));
            }
        }
        return stack.pop();
    }

    public static void main (String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Введите выражение:");
                System.out.print("-> ");
                String string = reader.readLine();
                if (string.equals("exit") || string.isEmpty()) {
                    break;
                }
                ExpressionParser parser = new ExpressionParser();
                List<String> expression = parser.parse(string);
                boolean flag = parser.isFlag();
                if (flag) {
                    for (String x : expression) {
                        System.out.print(x + " ");
                    }
                    System.out.println();
                    System.out.println(calc(expression));
                }
            } catch (ParserException e) {
                System.out.println(e);
            } catch (NoSuchElementException e) {
                System.out.println("Выражение составлено неверно.");
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                System.out.println();
            }
        }
    }
}

