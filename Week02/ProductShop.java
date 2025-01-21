import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        while (!command.equals("Revision")){
            String[] tokens = command.split(", ");

            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> currentProduct = shops.get(shop);
            currentProduct.putIfAbsent(product, price);

            command = scanner.nextLine();
        }
        shops.forEach((k, v) -> {
            System.out.println(k + "->");
            v.forEach((product, price) -> System.out.printf("Product: %s, Price: %.1f\n", product, price));
        });
    }
}
