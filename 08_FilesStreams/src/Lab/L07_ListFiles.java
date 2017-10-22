package Lab;

import java.io.File;

public class L07_ListFiles {
    public static void main(String[] args) {
        final String folderPath = "exampleFolder";
        File example = new File(folderPath);
        if (example.isDirectory()) {
            File[] files = example.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: %s%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
