package Exercises;

import java.util.*;

public class P04_TruckTour {
    public static void main(String[] args) {
        Deque<long[]> stations = fillStations();
        findFirstPoint(stations);
    }

    private static void findFirstPoint(Deque<long[]> stations) {

        int counter = 0;
        while (true) {
            boolean stationFound = true;
            long tankCapacity = 0L;

            // iterate through all stations to find if petrol would be enough
            for (long[] station : stations) {
                long petrol = station[0];
                long distanceToNext = station[1];
                tankCapacity += petrol;
                if (tankCapacity < distanceToNext) {
                    stationFound = false;
                    break;
                }
                tankCapacity -= distanceToNext;
            }

            if (stationFound) {
                System.out.println(counter);
                break;
            }
            stations.addLast(stations.pop());   // shift stations
            counter++;
        }
    }

    private static Deque<long[]> fillStations() {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Deque<long[]> stations = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            long[] station = new long[2];
            String[] input = scanner.nextLine().split(" ");
            station[0] = Long.parseLong(input[0]);    // add amount of petrol
            station[1] = Long.parseLong(input[1]);    // add distance to next station
            stations.add(station);
        }
        return stations;
    }
}
