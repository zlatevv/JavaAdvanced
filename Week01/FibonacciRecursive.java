import java.util.Scanner;

public class FibonacciRecursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long[] ml = new long[n + 1];
        long fibonacci = findFibonacci(n, ml);
        System.out.println(fibonacci);
    }

    private static long findFibonacci(int n, long[] ml) {

        if (n <= 1) {
            return 1;
        }
        if (ml[n] != 0) {
            return ml[n];
        }
        long currentFibonacci = findFibonacci(n - 1, ml) + findFibonacci(n - 2, ml);
        ml[n] = currentFibonacci;
        return currentFibonacci;

    }
}
