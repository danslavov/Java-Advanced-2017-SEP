package Exercises;

import java.util.Scanner;

public class P03_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for (String word : bannedWords) {
                String replacement = buildReplacement(word);
                text = text.replace(word, replacement);
        }
        System.out.println(text);
    }

    private static String buildReplacement(String word) {
        String replacement = "";
        for (int i = 0; i < word.length(); i++) {
            replacement += "*";
        }
        return replacement;
    }
}
