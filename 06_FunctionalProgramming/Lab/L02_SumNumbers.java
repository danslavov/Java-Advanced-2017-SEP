package Lab;

import java.util.Scanner;
import java.util.function.Function;

public class L02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s*,\\s*");
        Function<String, Integer> parsing = s -> Integer.parseInt(s);
        printSum(input, parsing);
    }

    private static void printSum(String[] input, Function<String, Integer> parsing) {
        System.out.println("Count = " + input.length);
        int sum = 0;
        for (String s : input) {
            sum += parsing.apply(s);
        }
        System.out.println("Sum = " + sum);
    }
}
