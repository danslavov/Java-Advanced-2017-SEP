package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P13_BlurFilter {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long blurValue = Integer.parseInt(scanner.nextLine());
        long[][] matrix = createMatrix();
        applyBlur(matrix, blurValue);
        printResult(matrix);
    }

    private static void printResult(long[][] matrix) {
        for (long[] row : matrix) {
            System.out.println(Arrays.toString(row)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }

    private static void applyBlur(long[][] matrix, long blurValue) {
        String[] blurCoordinates = scanner.nextLine().split(" ");
        int inputRow = Integer.parseInt(blurCoordinates[0]);
        int inputCol = Integer.parseInt(blurCoordinates[1]);
        int startRow = (inputRow - 1) < 0 ? (0) : (inputRow - 1);
        int endRow = (inputRow + 1 > matrix.length - 1) ? (matrix.length - 1) : (inputRow + 1);
        int startCol = (inputCol - 1) < 0 ? (0) : (inputCol - 1);
        int endCol = (inputCol + 1 > matrix[0].length - 1) ? (matrix[0].length - 1) : (inputCol + 1);

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                matrix[i][j] += blurValue;
            }
        }
    }

    private static long[][] createMatrix() {
        String[] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Long.parseLong(currentRow[j]);
            }
        }
        return matrix;
    }
}
