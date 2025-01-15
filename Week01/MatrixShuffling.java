import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];
        String[][] matrix = new String[rows][cols];
        matrixFill(matrix, scanner, rows);
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("END")){
            String currentCommand = command[0];
            if (currentCommand.equals("swap") && command.length == 5){
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                if (!isValid(row1, col1, row2, col2, rows, cols)){
                    System.out.println("Invalid input!");
                }else{
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    printMatrix(matrix);
                }
            }else{
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine().split("\\s+");
        }
    }

    private static void matrixFill(String[][] matrix, Scanner scanner, int row) {
        for (int i = 0; i < row; i++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            matrix[i] = currentRow;
        }
    }
    private static boolean isValid(int row1, int col1, int row2, int col2, int rows, int cols){
        return row1 >= 0 && row1 < rows &&
                row2 >= 0 && row2 < rows &&
                col1 >= 0 && col1 < cols &&
                col2 >= 0 && col2 < cols;
    }
    private static void printMatrix(String[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
