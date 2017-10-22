package Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01_StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = reader.readLine().trim();
            if (line.equals("END")) {
                break;
            }
            if (!line.isEmpty()) {
                lines.add(line);
            }
        }
        lines.stream()
                .filter(str -> str.charAt(str.length() - 1) == '2')
                .sorted()
                .forEach(str -> System.out.printf(
                        "%s%n", str.substring(0, str.length() - 2)
                ));
    }
}
