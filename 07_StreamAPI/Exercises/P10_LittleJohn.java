package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10_LittleJohn {
    public static void main(String[] args) throws IOException {

        String[] input = readInput();
        Map<String, Integer> arrows = getArrows(input);
        int code = encryptCounts(arrows.values().stream().mapToInt(Integer::valueOf).toArray());
        System.out.println(code);
    }

    private static int encryptCounts(int[] values) {
        int result = Integer.parseInt(String.valueOf(values[2]) + values[1] + values[0]);
        StringBuilder resultAsString = new StringBuilder(Integer.toBinaryString(result));
        StringBuilder reversedResult = new StringBuilder(resultAsString);
        reversedResult.reverse();
        resultAsString.append(reversedResult);
        return Integer.parseInt(resultAsString.toString(), 2);
    }

    private static Map<String, Integer> getArrows(String[] input) {
        Map<String, Integer> arrows = new LinkedHashMap<>();
        arrows.put("large", getArrowsBySize(input, "large"));
        arrows.put("medium", getArrowsBySize(input, "medium"));
        arrows.put("small", getArrowsBySize(input, "small"));
        return arrows;
    }

    private static int getArrowsBySize(String[] input, String size) {
        int arrowCount = 0;
        Pattern pattern = Pattern.compile(getPattern(size));
        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);
            while (matcher.find()) {
                arrowCount++;
                input[i] = input[i].replaceAll(matcher.group(), "&");
            }
        }
        return arrowCount;
    }

    private static String getPattern(String size) {
        switch (size) {
            case "large":
                return ">{3}-{5}>{2}";
            case "medium":
                return ">{2}-{5}>{1}";
            case "small":
                return ">{1}-{5}>{1}";
            default:
                return "";
        }
    }

    private static String[] readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[4];
        for (int i = 0; i < 4; i++) {
            input[i] = reader.readLine();
        }
        return input;
    }
}
