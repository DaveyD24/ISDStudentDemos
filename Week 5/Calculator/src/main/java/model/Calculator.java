package model;

import java.util.Arrays;
import java.util.LinkedList;

enum OPERATOR {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        return a / b;
    }

    public static int evaluate(String expression) {
        LinkedList<String> tokens = new LinkedList<String>(Arrays.asList(expression.split(" +")));
        int result = 0;
        OPERATOR operator = null;
        for (int i = 0; i < tokens.size(); i++) {
            try {
                int value = Integer.parseInt(tokens.get(i));
                if (i == 0) {
                    result = value;
                }
                else {
                    assert operator != null;
                    result = switch (operator) {
                        case ADD -> add(result, value);
                        case SUBTRACT -> sub(result, value);
                        case MULTIPLY -> mul(result, value);
                        case DIVIDE -> div(result, value);
                    };
                }
            }
            catch (NumberFormatException e) {
                operator = switch (tokens.get(i)) {
                    case "+" -> OPERATOR.ADD;
                    case "-" -> OPERATOR.SUBTRACT;
                    case "*" -> OPERATOR.MULTIPLY;
                    case "/" -> OPERATOR.DIVIDE;
                    default -> operator;
                };
            }
        }
        return result;
    }
}
