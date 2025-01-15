import java.util.Scanner;

public class TheMAtrix {

    // Directions for up, down, left, right movements
    private static final int[] DIRS = {-1, 1, 0, 0}; // up, down, left, right

    // Method to perform the flood-fill using DFS
    public static void floodFill(char[][] matrix, int R, int C, int startRow, int startCol, char fillChar) {
        char startChar = matrix[startRow][startCol];

        // If the fillChar is the same as startChar, no filling is necessary
        if (startChar == fillChar) return;

        // Perform DFS from the starting point
        dfs(matrix, R, C, startRow, startCol, startChar, fillChar);
    }

    // DFS Helper Method
    private static void dfs(char[][] matrix, int R, int C, int row, int col, char startChar, char fillChar) {
        // Base case: check if the current position is out of bounds or not the startChar
        if (row < 0 || row >= R || col < 0 || col >= C || matrix[row][col] != startChar) {
            return;
        }

        // Fill the current cell with the fillChar
        matrix[row][col] = fillChar;

        // Explore the neighbors (up, down, left, right)
        dfs(matrix, R, C, row - 1, col, startChar, fillChar); // Up
        dfs(matrix, R, C, row + 1, col, startChar, fillChar); // Down
        dfs(matrix, R, C, row, col - 1, startChar, fillChar); // Left
        dfs(matrix, R, C, row, col + 1, startChar, fillChar); // Right
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read matrix dimensions
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();  // Consume newline

        // Read the matrix
        char[][] matrix = new char[R][C];
        for (int i = 0; i < R; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < C; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        // Read the fill character
        char fillChar = sc.nextLine().charAt(0);

        // Read the starting position
        int startRow = sc.nextInt();
        int startCol = sc.nextInt();

        // Perform the flood fill
        floodFill(matrix, R, C, startRow, startCol, fillChar);

        // Output the modified matrix
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
