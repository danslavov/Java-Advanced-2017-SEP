package Exercises;

import java.util.Scanner;

public class P07_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.next();
        String secondString = scanner.next();
        String tmp;
        if (firstString.length() < secondString.length()) {
            tmp = firstString;
            firstString = secondString;
            secondString = tmp;
        }
        int result = 0;

        for (int i = 0; i < firstString.length(); i++) {
            if (i < secondString.length()) {
                result += (firstString.charAt(i) * secondString.charAt(i));
            } else {
                result += firstString.charAt(i);
            }
        }
        System.out.println(result);
    }
}
