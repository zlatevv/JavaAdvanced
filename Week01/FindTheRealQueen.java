
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];
        matrixFill(matrix, scanner);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j] == 'q'){
                    if (isValid(matrix, i, j)){
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
    }

    private static void matrixFill(char[][] matrix, Scanner scanner) {
        for (int i = 0; i < 8; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[i] = currentRow;
        }
    }
    private static boolean isValid(char[][] chessboard, int row, int col) {
        for (int i = 0; i < 8; i++) {
            if (i != col && chessboard[row][i] == 'q') {
                return false;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (i != row && chessboard[i][col] == 'q') {
                return false;
            }
        }

        // Check diagonals
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != row && j != col && chessboard[i][j] == 'q') {
                    if (Math.abs(i - row) == Math.abs(j - col)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
