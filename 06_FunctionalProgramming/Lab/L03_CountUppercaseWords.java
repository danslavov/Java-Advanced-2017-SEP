package Lab;

import java.util.Scanner;
import java.util.function.Predicate;

public class L03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Predicate<String> test =
                word -> Character.isUpperCase(word.charAt(0));
        processInput(input, test);
        processInput(input, test, true);
    }

    private static void processInput(String[] input, Predicate<String> firstIsUpper, boolean b) {
        for (String s : input) {
            if (firstIsUpper.test(s)) {
                System.out.println(s);
            }
        }
    }

    private static void processInput(String[] input, Predicate<String> firstIsUpper) {
        int count = 0;
        for (String s : input) {
            if (firstIsUpper.test(s)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
