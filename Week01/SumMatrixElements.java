import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = input[0];
        int col = input[1];
        int[][] matrix = new int[row][col];
        int sum = 0;
        matrixFill(matrix, scanner, row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);
    }

    private static void matrixFill(int[][] matrix, Scanner scanner, int row) {
        for (int i = 0; i < row; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }
    }
}
