package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class L01_MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String input = reader.readLine();
        printExpressions(input);
//        int nothing = printExpressionsRecursion(input);
    }

    private static int printExpressionsRecursion(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                System.out.printf("(%s)%n", input.substring(0, i));
                return i + 1;
            } else if (input.charAt(i) == '(') {
                i += printExpressionsRecursion(input.substring(i + 1));
            }
        }
        return 0;
    }

    private static void printExpressions(String input) {
        List<Integer> bracketIndexes = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                bracketIndexes.add(i);
            } else if (input.charAt(i) == ')') {
                System.out.println(input.substring(
                                bracketIndexes.get(
                                        bracketIndexes.size() - 1), i + 1
                        )
                );
                bracketIndexes.remove(bracketIndexes.size() - 1);
            }
        }
    }
}
