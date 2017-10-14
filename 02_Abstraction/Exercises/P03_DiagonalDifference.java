package Exercises;

import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        int[][] matrix = fillMatrix();
        calculateAndPrintResult(matrix);
    }

    private static void calculateAndPrintResult(int[][] matrix) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][matrix.length - 1 - i];
        }
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static int[][] fillMatrix() {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        return matrix;
    }
}
