package Lab;

import java.util.Scanner;

public class L05_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = Double.parseDouble(scanner.nextLine());
        String dayNight = scanner.nextLine().toLowerCase();

        double taxiDayTariff = 0.79;
        double taxiNightTariff = 0.9;
        double busTariff = 0.09;
        double trainTariff = 0.06;
        double cost = 0;

        if (distance < 20) {
            if (dayNight.equals("day")) {
                cost = distance * taxiDayTariff + 0.7;
            } else {
                cost = distance * taxiNightTariff + 0.7;
            }
        } else if (distance < 100) {
            cost = distance * busTariff;
        } else {
            cost = distance * trainTariff;
        }

        System.out.printf("%.2f", cost);
    }
}
