import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> countries = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            int population = Integer.parseInt(tokens[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            Map<String, Integer> cities = countries.get(country);
            cities.put(city, population);

            input = scanner.nextLine();
        }
        countries.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(
                        totalPopulation(e2.getValue()),
                        totalPopulation(e1.getValue())))
                .forEach(entry -> {
                    String country = entry.getKey();
                    Map<String, Integer> cities = entry.getValue();

                    System.out.println(country + " (total population: " + totalPopulation(cities) + ")");
                    cities.entrySet()
                            .stream()
                            .sorted((c1, c2) -> Integer.compare(c2.getValue(), c1.getValue()))
                            .forEach(cityEntry ->
                                    System.out.println("=>" + cityEntry.getKey() + ": " + cityEntry.getValue()));
                });
    }

    private static int totalPopulation(Map<String, Integer> v) {
        AtomicInteger sum = new AtomicInteger();
        v.forEach((city,people) -> {
            sum.addAndGet(people);
        });
        return sum.get();
    }
}
