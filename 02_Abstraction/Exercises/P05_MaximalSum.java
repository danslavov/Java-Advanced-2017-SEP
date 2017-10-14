package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MaximalSum {
    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        findAndPrintResult(matrix);
    }

    private static void findAndPrintResult(int[][] matrix) {
        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = calculateSum(matrix, row, col, 3, 3);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        printResult(bestSum, matrix, bestRow, bestCol, 3, 3);
    }

    // can be used for submatrix of variable dimensions
    private static void printResult(
            int bestSum, int[][] matrix, int bestRow, int bestCol, int submatrixRow, int submatrixCol) {
        System.out.println("Sum = " + bestSum);
        for (int row = bestRow; row < bestRow + submatrixRow; row++) {
            for (int col = bestCol; col < bestCol + submatrixCol; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    // can be used for submatrix of variable dimensions
    private static int calculateSum(
            int[][] matrix, int row, int col, int submatrixRow, int submatrixCol) {
        int sum = 0;
        for (int i = row; i < row + submatrixRow; i++) {
            for (int j = col; j < col + submatrixCol; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static int[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] line = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }
        return matrix;
    }
}
