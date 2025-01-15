import java.util.Arrays;
import java.util.Scanner;

public class CrossFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];
        matrixFill(matrix, scanner, rows, cols);

        String command = scanner.nextLine();
        while (!(command.equals("Nuke it from orbit"))){
            String[] tokens = command.split(" ");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);
            for (int i = row - radius; i <= row + radius; i++) {
                if (i >= 0 && i < matrix.length && col > 0 && col < matrix[0].length) {
                    matrix[i][col] = 0;
                }
            }
            for (int i = col - radius; i <= col + radius; i++) {
                if (i >= 0 && i < matrix[0].length && row > 0 && row < matrix.length){
                    matrix[row][i] = 0;
                }
            }
            command = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static void matrixFill(int[][] matrix, Scanner scanner, int row, int col) {
        int counter = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = counter++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
