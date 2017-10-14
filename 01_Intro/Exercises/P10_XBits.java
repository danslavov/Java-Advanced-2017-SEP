package Exercises;

import java.util.Scanner;

public class P10_XBits {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] binaries = fillBinaries();
        findXBits(binaries);
    }

    private static void findXBits(String[] binaries) {
        int xBitCount = 0;

        for (int i = 0; i < binaries.length - 2; i++) {
            for (int j = 0; j < binaries[i].length() - 2; j++) {
                String top = binaries[i].substring(j, j + 3);
                String middle = binaries[i + 1].substring(j, j + 3);
                String bottom = binaries[i + 2].substring(j, j + 3);
                if (top.equals("101") && middle.equals("010") && bottom.equals("101")) {
                    xBitCount++;
                }
            }
        }
        System.out.println(xBitCount);
    }

    private static String[] fillBinaries() {
        String[] binaries = new String[8];
        for (int i = 0; i < 8; i++) {
            int inputNumber = scanner.nextInt();
            String numberToBinaryString = String
                    .format("%32s", Integer.toBinaryString(inputNumber))
                    .replace(' ', '0');
            binaries[i] = numberToBinaryString;
        }
        return binaries;
    }
}
