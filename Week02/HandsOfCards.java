import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> playersCards = new HashMap<>();
        Map<String, Integer> handsOfCards = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            playersCards.putIfAbsent(name, new HashSet<>());
            handsOfCards.putIfAbsent(name, 0);

            for (String currentCard : cards) {

                if (playersCards.get(name).contains(currentCard)) {
                    continue;
                }

                playersCards.get(name).add(currentCard);

                String powerStr = currentCard.substring(0, currentCard.length() - 1);
                char type = currentCard.charAt(currentCard.length() - 1);

                int power;
                if (powerStr.equals("J")) {
                    power = 11;
                } else if (powerStr.equals("Q")) {
                    power = 12;
                } else if (powerStr.equals("K")) {
                    power = 13;
                } else if (powerStr.equals("A")) {
                    power = 14;
                } else {
                    power = Integer.parseInt(powerStr);
                }

                int totalPoints = 0;
                switch (type) {
                    case 'S':
                        totalPoints = power * 4;
                        break;
                    case 'H':
                        totalPoints = power * 3;
                        break;
                    case 'D':
                        totalPoints = power * 2;
                        break;
                    case 'C':
                        totalPoints = power * 1;
                        break;
                    default:
                        continue;
                }

                handsOfCards.put(name, handsOfCards.get(name) + totalPoints);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : handsOfCards.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
