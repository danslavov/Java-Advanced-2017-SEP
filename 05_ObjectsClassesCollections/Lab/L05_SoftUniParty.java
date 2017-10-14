package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class L05_SoftUniParty {
    private static BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
    );
    public static void main(String[] args) throws IOException {
        Set<String> invited = readInvited();
        removeAttended(invited);
        System.out.println(invited.size());
//        printNotAttended(invited, true);
//        printNotAttended(invited, false);
        invited.forEach(System.out::println);
    }

    private static void printNotAttended(Set<String> invited, boolean vipNeeded) {

        for (String guest : invited) {
            boolean isVip = Character.isDigit(guest.charAt(0));
            if (isVip && vipNeeded) {
                System.out.println(guest);
            } else if (!isVip && !vipNeeded) {
                System.out.println(guest);
            }
        }
    }

    private static void removeAttended (Set<String> invited) throws IOException {
        String guest = reader.readLine();
        while (!guest.equals("END")) {
            if (invited.contains(guest)) {
                invited.remove(guest);
            }
            guest = reader.readLine();
        }
    }

    private static Set<String> readInvited() throws IOException {
        Set<String> invited = new TreeSet<>();
        String guest = reader.readLine();
        while (!guest.equals("PARTY")) {
            invited.add(guest);
            guest = reader.readLine();
        }
        return invited;
    }
}
