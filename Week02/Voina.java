import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        int[] firstCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int card : firstCards){
            firstPlayer.add(card);
        }
        for (int card : secondCards){
            secondPlayer.add(card);
        }
        int counter = 50;
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty() && counter > 0) {
            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);
            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);
            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber){
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
            counter--;
        }
        if (firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }else if(secondPlayer.size() > firstPlayer.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
