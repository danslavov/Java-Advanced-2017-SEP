package Exercises;

import java.util.Scanner;

public class P02_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder a = new StringBuilder(scanner.nextLine());
        StringBuilder b = new StringBuilder(scanner.nextLine());
        deleteLeadingZeroes(a);
        deleteLeadingZeroes(b);

        StringBuilder result;
        if (a.length() >= b.length()) {
            result = calculateSum(a.reverse(), b.reverse());
        } else {
            result = calculateSum(b.reverse(), a.reverse());
        }
        System.out.println(result);
    }

    private static StringBuilder calculateSum(StringBuilder a, StringBuilder b) {
        StringBuilder result = new StringBuilder();
        int transfer = 0;
        int sum;

        for (int i = 0; i < b.length(); i++) {
            int aDigit = a.charAt(i) - 48;
            int bDigit = b.charAt(i) - 48;
            sum = aDigit + bDigit + transfer;
            result.append(sum % 10);
            transfer = sum / 10;
        }

        // add remaining digits from the bigger number
        for (int i = 0; i < a.length() - b.length(); i++) {
            sum = a.charAt(i + b.length()) - 48 + transfer;
            result.append(sum % 10);
            transfer = sum / 10;
        }
        if (transfer != 0) {
            result.append(transfer);
        }

        return result.reverse();
    }

    private static void deleteLeadingZeroes(StringBuilder sb) {
        while (sb.charAt(0) == 48) {
            sb.delete(0, 1);
        }
    }
}
