import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> countries = continents.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            List<String> cities = countries.get(country);
            cities.add(city);

        }
        continents.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach((country, cities) -> {
                System.out.println(" " + country + " -> " + String.join(", ", cities));
            });
        });
    }
}
