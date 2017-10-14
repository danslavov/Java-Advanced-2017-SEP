package Lab;

import java.util.Scanner;

public class L02_ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("://");
        String protocol = input[0];

        if (input.length < 2) {
            System.out.println("Invalid URL");
            return;
        }

        if (input[1].contains(":")) {
            System.out.println("Invalid URL");
            return;
        }
        int serverEndIndex = input[1].indexOf("/");
        if (serverEndIndex >= 0) {
            String server = input[1].substring(0, serverEndIndex);
            String resources = input[1].substring(serverEndIndex + 1);

            System.out.printf("Protocol = %s\nServer = %s\nResources = %s",
                    protocol, server, resources);
        } else {
            System.out.println("Invalid URL");
        }
    }
}
