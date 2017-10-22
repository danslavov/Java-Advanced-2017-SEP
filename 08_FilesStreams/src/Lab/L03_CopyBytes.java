package Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L03_CopyBytes {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";
        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            int oneBite = fis.read();
            while (oneBite >= 0) {
                if (oneBite == ' ' || oneBite == '\n') {
                    fos.write(oneBite);
                } else {
                    String number = String.valueOf(oneBite);
                    for (int i = 0; i < number.length(); i++) {
                        fos.write(number.charAt(i));
                    }
                }
                oneBite = fis.read();
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
