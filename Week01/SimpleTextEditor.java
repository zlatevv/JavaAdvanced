import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);
            switch (command){
                case 1 ->{
                    String string = input[1];
                    stack.push(text.toString());
                    text.append(string);
                }case 2 ->{
                    int count = Integer.parseInt(input[1]);
                    stack.push(text.toString());
                    text.delete(text.length() - count, text.length());
                }case 3 ->{
                    int index = Integer.parseInt(input[1]);
                    System.out.println(text.charAt(index - 1));
                }case 4 ->{
                    text = new StringBuilder(stack.pop());
                }
            }
        }

    }
}
