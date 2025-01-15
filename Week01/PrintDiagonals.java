import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCol = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowCol][rowCol];
        matrixFill(matrix, scanner, rowCol);
        int col = 0;
        for (int i = 0; i < rowCol; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = rowCol - 1; i >= 0; i--) {
            System.out.print(matrix[i][col] + " ");
            col++;
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
