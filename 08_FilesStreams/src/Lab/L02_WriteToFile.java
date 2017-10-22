package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class L02_WriteToFile {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            List<Character> punctuation = Arrays.asList(',', '.', '!', '?');
            int oneBite = fis.read();

            while (oneBite >= 0) {
                if (!punctuation.contains((char) oneBite)) {
                    fos.write(oneBite);
                }
                oneBite = fis.read();
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
