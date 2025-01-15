import java.util.Arrays;
import java.util.Scanner;

public class MaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = input[0];
        int col = input[1];
        int[][] matrix = new int[row][col];
        int maxSum = Integer.MIN_VALUE;
        int[][] coordinates = new int[2][];
        matrixFill(matrix, scanner, row);
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                int currentElement = matrix[i][j];
                int rightElement = matrix[i][j + 1];
                int downElement = matrix[i + 1][j];
                int diagonalElement = matrix[i + 1][j + 1];
                int currentSum = currentElement + rightElement + downElement + diagonalElement;
                if (maxSum < currentSum){
                    maxSum = currentSum;
                    coordinates = new int[][]{new int[]{currentElement, rightElement}, new int[]{downElement, diagonalElement}};
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(coordinates[i][0] + " " + coordinates[i][1]);
        }
        System.out.println(maxSum);
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
