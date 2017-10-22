package I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P01_BitFlipper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
//        solutionNoBitwise(input);    // Judge 70/100
        bitWiseSolution(input);
    }

    private static void bitWiseSolution(String input) {
        BigInteger num = new BigInteger(input);
        BigInteger zero = BigInteger.ZERO;
        BigInteger seven = new BigInteger("7"); // to apply a mask 111 by XOR

        // iterate 64 times to simulate a 64-bit number with leading zeroes;
        // minus 3 for the last triad
        for (int i = 0; i <= 61; i++) {

            // shiftRight cuts the digits to the right;
            // and(seven = 111) nullifies all digits in front of the last 3
            BigInteger triad = num.shiftRight(61 - i)
                    .and(seven);
            if (triad.equals(zero) || triad.equals(seven)) {

                // shiftLeft adds as many zeroes to the right
                // as we previously cut by shiftRight
                num = num.xor(seven.shiftLeft(61 - i));
                i += 2;
            }
        }
        System.out.println(num);
    }

    private static void solutionNoBitwise(String input) {
        long num = Long.parseLong(input);
        StringBuilder binary = new StringBuilder(Long.toBinaryString(num));
        padTo64symbols(binary);
        processTriads(binary);
        BigInteger result = new BigInteger(binary.toString(), 2);
        System.out.println(result);
    }

    private static void padTo64symbols(StringBuilder binary) {
        byte difference = (byte) (64 - (byte) binary.length());
        if (difference > 0) {
            for (int i = 0; i < difference; i++) {
                binary.insert(0, '0');
            }
        }
    }

    private static void processTriads(StringBuilder binary) {
        byte counter = 1;
        int i = 0;
        while (i < binary.length() - 1) {
            if (binary.charAt(i) == binary.charAt(i + 1)) {
                counter++;
                if (counter == 3) {
                    i++;
                    invert(binary, i);
                    counter = 1;
                }
            } else {
                counter = 1;
            }
            i++;
        }
    }

    private static void invert(StringBuilder binary, int i) {
        char inverted = '0';
        if (binary.charAt(i) == '0') {
            inverted = '1';
        }
        binary.setCharAt(i, inverted);
        binary.setCharAt(i - 1, inverted);
        binary.setCharAt(i - 2, inverted);
    }
}
