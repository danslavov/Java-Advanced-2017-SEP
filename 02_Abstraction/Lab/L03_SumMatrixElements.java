package Lab;

import java.util.Scanner;

public class L03_SumMatrixElements {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        printResult(matrix);
    }

    private static void printResult(int[][] matrix) {
        System.out.printf("%d%n%d%n", matrix.length, matrix[0].length);
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }
        System.out.println(sum);
    }

    private static int[][] createMatrix() {
        String[] size = scanner.nextLine().split(", ");
        byte rows = Byte.parseByte(size[0]);
        byte cols = Byte.parseByte(size[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }
}
