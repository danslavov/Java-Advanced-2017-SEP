package Lab;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class L05_PascalsTriangle {
    public static void main(String[] args) {
        BigInteger[][] pascalTriangle = createResult();
        System.out.println();
        printResult(pascalTriangle);
//        printResultAlternative(pascalTriangle);
    }

    private static void printResultAlternative(BigInteger[][] pascalTriangle) {
        for (BigInteger[] row : pascalTriangle) {
            for (BigInteger element : row) {
                if (element != null) {
                    System.out.print(element + " ");
                }
            }
            System.out.println();
        }
    }

    private static void printResult(BigInteger[][] pascalTriangle) {
        for (BigInteger[] row : pascalTriangle) {
            System.out.println(Arrays.toString(row)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", null", "")
                    .replace(",", ""));
        }
    }

    private static BigInteger[][] createResult() {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        BigInteger[][] result = new BigInteger[rows][rows];

        //set initial 1 or 2 rows with one's:
        if (rows < 1) {
            System.exit(0);
        } else {
           result[0][0] = new BigInteger("1");
           if (rows > 1) {
               result[1][0] = new BigInteger("1");
               result[1][1] = new BigInteger("1");
           }
        }

        //compute current value as the sum of the previous and current column from the previous row:
        for (int row = 2; row < rows; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    result[row][col] = new BigInteger("1");
                } else {
                    result[row][col] = result[row - 1][col - 1].add(result[row - 1][col]);
                }
            }
        }
        return result;
    }
}
