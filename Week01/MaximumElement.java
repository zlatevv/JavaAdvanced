import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);
            if (command == 1){
                int x = Integer.parseInt(input[1]);
                stack.push(x);
            }else if(command == 2){
                stack.pop();
            }else{
                int max = findMax(stack);
                System.out.println(max);
            }
        }
    }
    public static int findMax(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (int n: stack){
            if (n > max){
                max = n;
            }
        }
        return max;
    }

}
