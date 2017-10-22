package Lab;

import java.io.*;
import java.util.Scanner;

public class L04_ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    writer.println(number);
                } else {
                    scanner.next();
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
