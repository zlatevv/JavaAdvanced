import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        matrixFill(matrix, scanner, n);
        int firstDiagonal = getFirstDiagonal(matrix);
        int secondDiagonal = getSecondDiagonal(matrix);
        int difference = abs(firstDiagonal - secondDiagonal);
        System.out.println(difference);
    }

    private static int getFirstDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int getSecondDiagonal(int[][] matrix) {
        int sum = 0;
        int col = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[i][col];
            col++;
        }
        return sum;
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
