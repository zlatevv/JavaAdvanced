import java.sql.PreparedStatement;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        Collections.addAll(stack, parts);
        int result = 0;
        while (stack.size() > 1){
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());
            if (operator.equals("+")){
                result = firstNumber + secondNumber;
            }else{
                result = firstNumber - secondNumber;
            }stack.push(String.valueOf(result));

        }
        System.out.println(stack.peek());
    }
}
