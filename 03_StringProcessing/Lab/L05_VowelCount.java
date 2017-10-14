package Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L05_VowelCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = findCount(input);
        System.out.println("Vowels: " + count);
    }

    private static int findCount(String input) {
        int count = 0;
        Pattern pattern = Pattern.compile("[AEOUIYaeouiy]");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
