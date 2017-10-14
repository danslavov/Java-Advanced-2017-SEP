package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01_FillMatrix {
    public static void main(String[] args) {
        int[][] matrix = fillMatrix();
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            System.out.println(Arrays.toString(line)
            .replace("[", "")
            .replace("]", "")
            .replace(",", ""));
        }
    }

    private static int[][] fillMatrix() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char pattern = input[1].charAt(0);
        int[][] matrix;
        if (pattern == 'A') {
            matrix = fillPatternA(n);
        } else {
            matrix = fillPatternB(n);
        }
        return matrix;
    }

    private static int[][] fillPatternA(int n) {
        int[][] matrix = new int[n][n];
        int elementValue = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = elementValue;
                elementValue++;
            }
        }
        return matrix;
    }

    private static int[][] fillPatternB(int n) {
        int[][] matrix = new int[n][n];
        int elementValue = 1;
        for (int col = 0; col < n; col++) {

            if (col % 2 != 0) {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = elementValue;
                    elementValue++;
                }
            } else {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = elementValue;
                    elementValue++;
                }
            }
        }
        return matrix;
    }
}
