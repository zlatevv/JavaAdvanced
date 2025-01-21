import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> charCounter = new TreeMap<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            charCounter.putIfAbsent(currentChar, 0);
            charCounter.put(currentChar, charCounter.get(currentChar) + 1);
        }
        charCounter.forEach((k,v) -> {
            System.out.println(k + ": " + v + " time/s");
        });
    }
}
