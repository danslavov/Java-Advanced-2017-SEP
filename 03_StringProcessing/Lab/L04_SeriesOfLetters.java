package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L04_SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        processInputByStrings(input);
//        processInputByChars(input);
    }

    private static void processInputByChars(String input) {
        List<Character> singleLetters = new ArrayList<>();
        singleLetters.add(input.charAt(0));

        for (int i = 0; i < input.toCharArray().length - 1; i++) {
            char current = input.charAt(i);
            char next = input.charAt(i + 1);
            if (current != next) {
                singleLetters.add(next);
            }
        }

        System.out.println(
                singleLetters.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""))
        );
    }

    private static void processInputByStrings(String input) {
        List<String> singleLetters = new ArrayList<>();
        singleLetters.add(input.charAt(0) + "");

        for (int i = 0; i < input.toCharArray().length - 1; i++) {
            String current = input.charAt(i) + "";
            String next = input.charAt(i + 1) + "";
            if (!current.equals(next)) {
                singleLetters.add(next);
            }
        }

        System.out.println(String.join("", singleLetters));
    }
}
