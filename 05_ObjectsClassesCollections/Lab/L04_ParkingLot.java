package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L04_ParkingLot {
    public static void main(String[] args) throws IOException {
        Set<String> plates = fillPlates();
        printResult(plates);
    }

    private static void printResult(Set<String> plates) {
        if (plates.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String plate : plates) {
                System.out.println(plate);
            }
        }
    }

    private static Set<String> fillPlates() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        Set<String> plates = new HashSet<>();
        while (true) {
            String[] input = reader.readLine().split(", ");
            char direction = input[0].charAt(0);
            if (direction == 'E') {
                break;
            }
            String plate = input[1];
            if (direction == 'I') {
                plates.add(plate);
            } else {
                plates.remove(plate);
            }
        }
        return plates;
    }
}
