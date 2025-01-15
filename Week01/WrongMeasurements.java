import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCount = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowCount][];
        int[][] fixedMatrix = new int[rowCount][];
        matrixFill(matrix, scanner, rowCount);
        int[] coordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = coordinates[0];
        int col = coordinates[1];
        int wrongNumber = matrix[row][col];
        for (int i = 0; i < rowCount; i++) {
            fixedMatrix[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongNumber){
                    int sum = 0;
                    if (i > 0 && j <  matrix[i - 1].length && matrix[i - 1][j] != wrongNumber){
                        sum += matrix[i - 1][j];
                    }if (i < rowCount - 1 && j < matrix[i + 1].length && matrix[i + 1][j] != wrongNumber){
                        sum += matrix[i + 1][j];
                    }if (j > 0 && matrix[i][j - 1] != wrongNumber){
                        sum += matrix[i][j - 1];
                    }if (j < matrix[i].length - 1 && matrix[i][j + 1] != wrongNumber){
                        sum += matrix[i][j + 1];
                    }
                    fixedMatrix[i][j] = sum;
                }else{
                    fixedMatrix[i][j] = matrix[i][j];
                }
            }
        }
        printMatrix(fixedMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
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
