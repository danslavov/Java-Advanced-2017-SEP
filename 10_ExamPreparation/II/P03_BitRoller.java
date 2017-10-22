package II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_BitRoller {
    public static void main(String[] args) throws IOException {

        // read input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int frozenRank = Integer.parseInt(reader.readLine());
        int rounds = Integer.parseInt(reader.readLine());

        int frozenValue = num >> frozenRank & 1;

        // create mask for keeping frozen byte at constant value
        // and postforzen byte (if any) at the opposite value
        int frozenMask = (frozenRank > 0) ? (3 << frozenRank - 1) : (1);

        // create mask to transfer the most right digit to the most left position
        int rollingMask = 1 << 18;

        for (int i = 0; i < rounds; i++) {

            // save the last digit
            int lastDigit = (frozenRank > 0) ? (num & 1) : (num >> 1 & 1);

            // shift the number to the right
            num = num >> 1;

            if (lastDigit == 1) {
                num = num | rollingMask;
            }

            int currentFrozenValue = num >> frozenRank & 1;

            // if value of the frozen byte has changed, both this value
            // and the next one should be reversed and after reversion
            // they should have opposite values
            if (currentFrozenValue != frozenValue) {
                num = num ^ frozenMask;
            }
        }
        System.out.println(num);
    }
}