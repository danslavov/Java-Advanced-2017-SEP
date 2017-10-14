package Exercises;

import java.util.Scanner;

public class P04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double exponentF1 = (a + b + c) / Math.sqrt(c);
        double baseF1 = (Math.pow(a, 2) + Math.pow(b, 2)) /
                (Math.pow(a, 2) - Math.pow(b, 2));
        double exponentF2 = a - b;
        double baseF2 = Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3);

        double f1 = Math.pow(baseF1, exponentF1);
        double f2 = Math.pow(baseF2, exponentF2);
        double result = Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2));

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",
                f1, f2, result
        );
    }
}
