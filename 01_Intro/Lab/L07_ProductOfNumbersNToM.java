package Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class L07_ProductOfNumbersNToM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();
        BigInteger result = BigInteger.ONE; // = new BigInteger("1");
        for (int i = startNum; i <= endNum; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.printf(
                "product[%d..%d] = %d", startNum, endNum, result);
    }
}
