
import java.util.Scanner;

public class MatrixOfPallindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
                            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "aa"};

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];
        matrixFill(matrix, rows, letters);

        printMatrix(matrix);
    }

    private static void matrixFill(String[][] matrix, int row, String[] letters) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String currentText = letters[i] +
                        letters[i + j] +
                        letters[i];
                matrix[i][j] = currentText;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }
}
