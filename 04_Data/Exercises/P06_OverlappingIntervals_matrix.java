package Exercises;

import java.util.Scanner;

public class P06_OverlappingIntervals_matrix {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] intervals = fillMatrix(rows);
        boolean result = findOverlaps(intervals);
        System.out.println(result);
    }

    private static boolean findOverlaps(int[][] intervals) {
        for (int row = 0; row < intervals.length - 1; row++) {
            int start = intervals[row][0];
            int end = intervals[row][1];
            for (int remaining = row + 1; remaining < intervals.length; remaining++) {
                int nextStart = intervals[remaining][0];
                int nextEnd = intervals[remaining][1];

                if ((start >= nextStart && start <= nextEnd) ||
                        (end >= nextStart && end <= nextEnd) ||
                        (nextStart >= start && nextStart <= end) ||
                        (nextEnd >= start && nextEnd <= end)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] fillMatrix(int rows) {
        int matrix[][] = new int[rows][2];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(",");
            matrix[row][0] = Integer.parseInt(line[0]);
            matrix[row][1] = Integer.parseInt(line[1]);
        }
        return matrix;
    }
}
