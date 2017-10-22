package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class P11_OfficeStuff {
    public static void main(String[] args) throws IOException {
        TreeMap<String, LinkedHashMap<String, Integer>> companies = getCompanyData();
        printResult(companies);
    }

    private static void printResult(
            TreeMap<String, LinkedHashMap<String, Integer>> companies) {

        //Iterate company names:
        for (Map.Entry<String, LinkedHashMap<String, Integer>> company : companies.entrySet()) {
            System.out.print(company.getKey() + ": ");

            // Iterate "product-quantity" pairs and append them to a SB separated by comma:
            StringBuilder nestedEntries = new StringBuilder();
            for (Map.Entry<String, Integer> productAndQuantity: company.getValue().entrySet()) {
                String entry = String.format("%s-%d, ",
                        productAndQuantity.getKey(), productAndQuantity.getValue());
                nestedEntries.append(entry);
            }

            // Delete the last ", " from the SB:
            nestedEntries.delete(nestedEntries.length() - 2, nestedEntries.length());

            System.out.println(nestedEntries);
        }
    }

    private static TreeMap<String, LinkedHashMap<String, Integer>> getCompanyData() throws IOException {
        TreeMap<String, LinkedHashMap<String, Integer>> companies = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            // Read each order and break it into components:
            String[] order = reader
                    .readLine()
                    .replaceAll("\\|", "")
                    .split(" - ");
            String companyName = order[0];
            int quantity = Integer.parseInt(order[1]);
            String product = order[2];

            // Update collection:
            companies.putIfAbsent(companyName, new LinkedHashMap<>());
            companies.get(companyName).putIfAbsent(product, 0);

            // !!! UPDATE VALUE IN NESTED MAP !!!
            companies.get(companyName).put(product, companies.get(companyName).get(product) + quantity);
        }
        return companies;
    }
}
