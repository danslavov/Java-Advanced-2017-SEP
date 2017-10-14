package Exercises;

import java.util.Scanner;

public class P04_2x2SquaresInMatrix {
    public static void main(String[] args) {
        char[][] matrix = createMatrix();
        printResult(matrix);
    }

    private static void printResult(char[][] matrix) {
        int matchCount = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                if (matrix[row][col] == matrix[row][col + 1] &&
                        matrix[row][col] == matrix[row + 1][col] &&
                        matrix[row][col] == matrix[row + 1][col + 1]) {
                    matchCount++;
                }
            }
        }
        System.out.println(matchCount);
    }

    private static char[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(" ");
            char[] charLine = convertToChars(line);
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = charLine[col];
            }
        }
        return matrix;
    }

    private static char[] convertToChars(String[] line) {
        char[] result = new char[line.length];
        for (int i = 0; i < line.length; i++) {
            result[i] = line[i].charAt(0);
        }
        return result;
    }
}
