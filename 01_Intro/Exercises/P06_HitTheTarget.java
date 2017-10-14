package Exercises;

import java.util.Scanner;

public class P06_HitTheTarget {

    private static void FindHits(int target, char minus) {
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i - j == target) {
                    System.out.printf("%d - %d = %d%n", i, j, target);
                }
            }
        }
    }

    private static void FindHits(int target) {
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == target) {
                    System.out.printf("%d + %d = %d%n", i, j, target);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        FindHits(target);
        FindHits(target, '-');
    }
}
