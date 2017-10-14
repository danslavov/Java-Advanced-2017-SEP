package Exercises;

import java.math.BigInteger;
import java.util.Scanner;

public class P04_CombinationsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = new BigInteger(scanner.nextLine());
        BigInteger k = new BigInteger(scanner.nextLine());

        BigInteger nFac = findFactorial(n);
        BigInteger nMinKFac = findFactorial(n.subtract(k));
        BigInteger kFac = findFactorial(k);

        BigInteger result = nFac.divide(nMinKFac.multiply(kFac));
        System.out.println(result);

    }

    private static BigInteger findFactorial(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) > 0) {
            return num.multiply(findFactorial(num.subtract(BigInteger.ONE)));
        } else {
            return BigInteger.ONE;
        }
    }
}
