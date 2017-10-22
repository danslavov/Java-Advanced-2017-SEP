/*
  90/100 in Judge probably due to
  some wrong using of StringBuilder
*/

package I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_Ascent {
    public static void main(String[] args) throws IOException {
        List<StringBuilder> input = getInput();
        Map<String, String> alreadyDecoded = new LinkedHashMap<>();
        decodeAndPrintLines(input, alreadyDecoded);
    }

    private static void decodeAndPrintLines(
            List<StringBuilder> input, Map<String, String> alreadyDecoded) {
        Pattern pattern = Pattern.compile("[,_][A-za-z]+\\d");

        for (StringBuilder line : input) {

            // replace previously decoded strings
            // with their memorized representations
            for (Map.Entry<String, String> entry : alreadyDecoded.entrySet()) {
                replace(line, entry);
            }

            // replace new matches with their decoded strings
            Matcher matcher = pattern.matcher(new StringBuilder(line));
            while (matcher.find()) {
                String match = matcher.group();
                String replacement = getReplacement(match);

                // memorize decoding
                alreadyDecoded.putIfAbsent(match, replacement);

                int startIndex = line.indexOf(match);
                line.delete(startIndex, startIndex + match.length());
                line.insert(startIndex, replacement);
            }

            System.out.println(line);
        }
    }

    private static String getReplacement(String match) {
        StringBuilder replacement = new StringBuilder();
        char operation = match.charAt(0);
        int value = Integer.parseInt(match.charAt(match.length() - 1) + "");

        for (int i = 1; i < match.length() - 1; i++) {
            char codedSymbol = match.charAt(i);
            char decodedSymbol = operation == ',' ?
                    (char) (codedSymbol + value) :
                    (char) (codedSymbol - value);
            replacement.append(decodedSymbol);
        }
        return replacement.toString();
    }

    private static void replace(
            StringBuilder line, Map.Entry<String, String> entry) {
        String from = entry.getKey();
        String to = entry.getValue();
        int index = line.indexOf(from);
        while (index >= 0) {
            line.delete(index, index + from.length());
            line.insert(index, to);
            index = line.indexOf(from);
        }
    }

    private static List<StringBuilder> getInput() throws IOException {
        List<StringBuilder> input = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder line = new StringBuilder(reader.readLine());
        while (!"Ascend".equals(line.toString())) {
            input.add(line);
            line = new StringBuilder(reader.readLine());
        }
        return input;
    }
}
