package Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L06_SortLines {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";
//        processWithPrintWriter(inputPath, outputPath);
        processWithFiles(inputPath, outputPath);
    }

    private static void processWithFiles(String inputPath, String outputPath) {
        Path in = Paths.get(inputPath);
        Path out = Paths.get(outputPath);
        try {
            List<String> lines = Files.readAllLines(in);
            lines.removeIf(String::isEmpty);    // not necessary for Judge
            Collections.sort(lines);
            Files.write(out, lines);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void processWithPrintWriter(String inputPath, String outputPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {
            List<String> result = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                if (!line.equals(""))
                result.add(line);
                line = reader.readLine();
            }
            Collections.sort(result);
            for (String s : result) {
                writer.println(s);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
