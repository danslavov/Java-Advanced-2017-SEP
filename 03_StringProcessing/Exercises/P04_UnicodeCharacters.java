package Exercises;

import java.util.Scanner;

public class P04_UnicodeCharacters {
    public static void main(String[] args) {
//        stringSolution();
        stringBuilderSolution();
    }

    private static void stringSolution() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            System.out.printf("\\u%04x", input.codePointAt(i));
        }
    }

    private static void stringBuilderSolution() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        for (int i = 0; i < input.length(); i++) {
            System.out.printf("\\u%04x", input.codePointAt(i));
        }
        System.out.println();
    }
}
