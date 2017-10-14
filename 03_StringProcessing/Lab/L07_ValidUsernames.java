package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L07_ValidUsernames {
    public static void main(String[] args) {
        List<String> results = readInput();
        if (results.contains("valid")) {
            for (String s : results) {
                System.out.println(s);
            }
        }
    }

    private static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?:[\\w-]){3,16}$");
        while (!input.equals("END")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                results.add("valid");
            } else {
                results.add("invalid");
            }
            input = scanner.nextLine();
        }
        return results;
    }
}
