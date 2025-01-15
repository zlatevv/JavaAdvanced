import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            if (a == '('){
                indexes.push(i);
            }else if (a == ')'){
                int startIndex = indexes.pop();
                System.out.println(input.substring(startIndex, i + 1));
            }
        }

    }
}
