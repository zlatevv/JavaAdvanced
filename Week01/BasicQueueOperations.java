import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] input =  scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        int min = Integer.MAX_VALUE;
        boolean isPresent = false;
        if (queue.isEmpty()){
            System.out.println(0);
            exit(0);
        }else{
            while (!queue.isEmpty()) {
                int number = queue.poll();
                if (number == x) {
                    isPresent = true;
                } else {
                    if (number < min) {
                        min = number;
                    }
                }
            }
        }
        if (isPresent){
            System.out.println("true");
        }else{
            System.out.println(min);
        }
    }
}
