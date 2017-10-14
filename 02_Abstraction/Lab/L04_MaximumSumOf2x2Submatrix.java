package Lab;

import java.util.Scanner;

public class L04_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        int matrix [][] = readMatrix();
        calculateAndPrintSubmatrix(matrix);
    }

    private static void calculateAndPrintSubmatrix(int[][] matrix) {
        int sum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int curSum = matrix[i][j] + matrix[i][j + 1]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (curSum > sum) {
                    sum = curSum;
                    bestRow = i;
                    bestCol = j;
                }
            }
        }
        printSubmatrix(matrix, sum, bestRow, bestCol);
    }

    private static void printSubmatrix(int[][] matrix, int sum, int bestRow, int bestCol) {
        String result = String.format("%d %d\n%d %d\n%d",
                matrix[bestRow][bestCol],
                matrix[bestRow][bestCol + 1],
                matrix[bestRow + 1][bestCol],
                matrix[bestRow + 1][bestCol + 1],
                sum);
        System.out.println(result);
    }

    private static int[][] readMatrix() {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        return matrix;
    }
}
