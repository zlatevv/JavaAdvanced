import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(queue::offer);
        int n = Integer.parseInt(scanner.nextLine());
        int rotations = 0;
        while (queue.size() > 1){
            String firstKid = queue.poll();

            rotations++;
            if (rotations % n == 0){
                System.out.println("Removed " + firstKid);
            }else{
                queue.offer(firstKid);
            }
        }
        System.out.println("Last is " + queue.peek());
    }
}
