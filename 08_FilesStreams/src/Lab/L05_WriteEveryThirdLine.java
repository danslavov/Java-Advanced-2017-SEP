package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class L05_WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {
            int counter = 1;
            while (scanner.hasNext()) {
                if (counter % 3 == 0) {
                    writer.println(scanner.nextLine());
                } else {
                    scanner.nextLine();
                }
                counter++;
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
