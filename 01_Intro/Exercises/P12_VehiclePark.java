package Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P12_VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> vehicles = new ArrayList<>(
                Arrays.asList(scanner.nextLine().split(" "))
        );
        int[] vehiclesSold = {0};   // array instead of primitive - to pass it by reference into the methods

        processQueries(scanner, vehicles, vehiclesSold);

        printResult(vehicles, vehiclesSold);
    }

    private static void processQueries(Scanner scanner, ArrayList<String> vehicles, int[] vehiclesSold) {
        while (true) {
            String[] query = scanner.nextLine().toLowerCase().split(" ");

            if(query[0].equals("end")) {
                break;
            }

            char vehicleType = query[0].charAt(0);
            String seatNumber = query[2];
            String vehicleNeeded = vehicleType + seatNumber;

            if(vehicles.contains(vehicleNeeded)) {
                int vehiclePrice = vehicleType * Integer.parseInt(seatNumber);
                vehicles.remove(vehicles.indexOf(vehicleNeeded));
                System.out.printf("Yes, sold for %d$%n", vehiclePrice);
                vehiclesSold[0]++;

            } else {
                System.out.println("No");
            }
        }
    }

    private static void printResult(ArrayList<String> vehicles, int[] vehiclesSold) {
        String vehiclesLeft = vehicles
                .toString()
                .replace("[", "")
                .replace("]", "");

        System.out.printf("Vehicles left: %s%nVehicles sold: %d%n",
                vehiclesLeft, vehiclesSold[0]);
    }
}
