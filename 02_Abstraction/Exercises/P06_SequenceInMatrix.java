package Exercises;

import java.util.Scanner;

public class P06_SequenceInMatrix {
    public static void main(String[] args) {
        String[][] matrix = createMatrix();
        findLongestSequence(matrix);

    }

    private static String[][] createMatrix() {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];
            }
        }
        return matrix;
    }

    private static void findLongestSequence(String[][] matrix) {
        String[] match = {""};      // both declared as array
        int[] matchCount = {0};     // to pass them by reference


        // What is the order of method execution ?

        searchByRow(matrix, match, matchCount);
        searchByColumn(matrix, match, matchCount);
        searchByDiagonalRight(matrix, match, matchCount); // right and left
        printResult(match, matchCount);


        System.out.println();
    }

    private static void printResult(String[] match, int[] matchCount) {
        for (int i = 0; i < matchCount[0]; i++) {
            System.out.print(match[0]);
            if (i < matchCount[0] - 1) {
                System.out.print(", ");
            }
        }
    }

//    private static void searchByDiagonalRight(
//            String[][] matrix, String[] match, int[] matchCount) {
//
//        for (int i = 0; i < Math.min(matrix.length, matrix[0].length); i++) {
//            int currentCount = 1;
//            String currentElement = matrix[i][i];
//        }
//
//
//    }

    private static void searchByColumn(
            String[][] matrix, String[] match, int[] matchCount) {

        match[0] = matrix[0][0];    // unnecessary?

        for (int col = 0; col < matrix[0].length; col++) {
            int currentCount = 1;
            String currentElement = "";

            for (int row = 0; row < matrix.length - 1; row++) {
                currentElement = matrix[row][col];
                String nextElement = matrix[row + 1][col];
                if (currentElement.equals(nextElement)) {
                    currentCount++;
                } else {
                    if ((currentCount >= matchCount[0])) {
                        match[0] = currentElement;
                        matchCount[0] = currentCount;
                        currentCount = 1;
                    }
                }
            }
            if ((currentCount >= matchCount[0])) {
                match[0] = currentElement;
                matchCount[0] = currentCount;
            }
        }
    }

    private static void searchByRow(
            String[][] matrix, String[] match, int[] matchCount) {

        match[0] = matrix[0][0];    // unnecessary?

        for (String[] row : matrix) {
            int currentCount = 1;
            String currentElement = "";

            for (int col = 0; col < row.length - 1; col++) {
                currentElement = row[col];
                String nextElement = row[col + 1];
                if (currentElement.equals(nextElement)) {
                    currentCount++;
                } else {
                    if ((currentCount >= matchCount[0])) {
                        match[0] = currentElement;
                        matchCount[0] = currentCount;
                        currentCount = 1;
                    }
                }
            }
            if ((currentCount >= matchCount[0])) {
                match[0] = currentElement;
                matchCount[0] = currentCount;
            }
        }
    }
}
