package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P02_MatrixOfPalindromes {
    public static void main(String[] args) {
        StringBuilder[][] matrix = createMatrix();
        printResult(matrix);
    }

    private static void printResult(StringBuilder[][] matrix) {
        for (StringBuilder[] line : matrix) {
            System.out.println(Arrays.toString(line)
            .replace("[", "")
            .replace("]", "")
            .replace(",", ""));
        }
    }

    private static StringBuilder[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        return fillMatrix(rows, cols);
    }

    private static StringBuilder[][] fillMatrix(int rows, int cols) {
        StringBuilder[][] matrix = new StringBuilder[rows][cols];
        for (int row = 0; row < rows; row++) {
            char firstAndThirdLetter = (char)(row + 97);
            for (int col = 0; col < cols; col++) {
                char secondLetter = (char)(row + col + 97);
                StringBuilder element = new StringBuilder()
                        .append(firstAndThirdLetter)
                        .append(secondLetter)
                        .append(firstAndThirdLetter);
                matrix[row][col] = element;
            }
        }
        return matrix;
    }
}
