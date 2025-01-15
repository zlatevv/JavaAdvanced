import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<String> queue = new PriorityQueue<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(queue::offer);
        int rotations = 0;
        while (queue.size() > 1){
            String firstKid = queue.poll();

            rotations++;
            if (isPrime(rotations)){
                System.out.println("Prime " + firstKid);
                queue.offer(firstKid);
            }else{
                System.out.println("Removed " + firstKid);
            }
        }
        System.out.println("Last is " + queue.peek());
    }
    public static boolean isPrime(int rotations){
        if (rotations == 1){
            return false;
        }
        for (int i = 2; i < rotations; i++) {
            if (rotations % i == 0){
                return false;
            }
        }
        return true;
    }
}
