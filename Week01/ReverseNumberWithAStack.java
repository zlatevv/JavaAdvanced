import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumberWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String number : numbers){
            stack.push(number);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
