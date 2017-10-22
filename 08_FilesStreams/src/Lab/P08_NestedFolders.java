package Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Queue;

public class P08_NestedFolders {
    public static void main(String[] args) {
        String path = "Files-and-Streams";
        File root = new File(path);
        int[] dirCount = {1};
//        processWithRecursion(root, dirCount, new StringBuilder());   // not for Judge
        processWithQueue(root, dirCount);
        System.out.println(dirCount[0] + " folders");
    }

    private static void processWithQueue(File root, int[] dirCount) {
        Queue<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            System.out.println(current.getName());
            File[] nested = current.listFiles();
            for (File file : nested) {
                if (file.isDirectory()) {
                    dirs.offer(file);
                    dirCount[0]++;
                }
            }
        }
    }

    private static void processWithRecursion(File current, int[] dirCount, StringBuilder indent) {
        System.out.println(indent + current.getName());
        File[] nested = current.listFiles();
        for (File file : nested) {
            if (file.isDirectory()) {
                dirCount[0]++;
                indent.append("--");
                processWithRecursion(file, dirCount, indent);
                indent.delete(indent.length() - 2, indent.length());
            }
        }
    }
}
