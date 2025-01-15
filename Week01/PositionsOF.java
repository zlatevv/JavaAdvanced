import java.util.Arrays;
import java.util.Scanner;

public class PositionsOF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int[][] matrix = new int[rows][];
        matrixFill(matrix, scanner, rows);
        int n = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == n){
                    found = true;
                    System.out.printf("%d %d\n", i, j);
                }
            }
        }
        if (!found){
            System.out.println("not found");
        }
    }

    private static void matrixFill(int[][] matrix, Scanner scanner, int row) {
        for (int i = 0; i < row; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }
    }
}
