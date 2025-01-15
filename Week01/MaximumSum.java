import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int m = input[1];
        int[][] matrix = new int[n][m];
        matrixFill(matrix, scanner, n);
        int maxSum = Integer.MIN_VALUE;
        int[][] coordinates = new int[3][3];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                int currentElement = matrix[i][j];
                int rightElement = matrix[i][j + 1];
                int downElement = matrix[i + 1][j];
                int diagonalElement = matrix[i + 1][j + 1];
                int doubleRight = matrix[i][j + 2];
                int doubleDown = matrix[i + 2][j];
                int doubleDiagonal = matrix[i + 2][j + 2];
                int downDoubleRight = matrix[i + 1][j + 2];
                int rightDoubleDown = matrix[i + 2][j + 1];
                int currentSum = currentElement + rightElement + doubleDiagonal + doubleDown + downDoubleRight +
                        downElement + diagonalElement + doubleRight + rightDoubleDown;
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    coordinates = new int[][]{
                            new int[]{currentElement, rightElement, doubleRight}, 
                            new int[]{downElement, diagonalElement, downDoubleRight},
                            new int[]{doubleDown, rightDoubleDown, doubleDiagonal}};
                            
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < 3; i++) {
            System.out.println(coordinates[i][0] + " " + coordinates[i][1] + " " + coordinates[i][2]);
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
