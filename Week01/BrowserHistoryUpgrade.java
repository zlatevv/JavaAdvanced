import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> trash = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() > 1) {
                    trash.push(stack.pop());
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if(input.equals("forward")){
                if (!trash.isEmpty()) {
                    stack.push(trash.pop());
                    System.out.println(stack.peek());
                }else{
                    System.out.println("no next URLs");
                }
            } else {
                stack.push(input);
                trash.clear();
                System.out.println(stack.peek());

            }
            input = scanner.nextLine();
        }
    }
}
