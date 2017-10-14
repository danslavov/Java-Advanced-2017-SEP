package Exercises;

import java.util.Scanner;

public class P09_ByteParty {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] nums = fillNumbers();

        processNumbers(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static int[] fillNumbers() {
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());;
        }
        return nums;
    }

    private static void processNumbers(int[] nums) {
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("party")) {
            String action = command[0];
            int position = Integer.parseInt(command[1]);

            for (int i = 0; i < nums.length; i++) {
                switch (action) {
                    case "-1":
                        nums[i] ^= (1 << position);
                        break;
                    case "0":
                        nums[i] &= ~(1 << position);
                        break;
                    case "1":
                        nums[i] |= (1 << position);
                        break;
                }
            }
            command = scanner.nextLine().split(" ");
        }
    }
}
