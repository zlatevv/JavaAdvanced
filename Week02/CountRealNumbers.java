import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double number : input){
            numbers.putIfAbsent(number, 0);
            numbers.put(number, numbers.get(number) + 1);
        }
        for (Map.Entry<Double, Integer> entry : numbers.entrySet()){
            System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
