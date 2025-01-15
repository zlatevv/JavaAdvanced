import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replace("Rotate(", "").replace(")", "");
        List<String> words = new ArrayList<>();


        int degrees = Integer.parseInt(input);
        int rotations = degrees / 90;


        input = scanner.nextLine();
        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }
        int rows = words.size();
        int cols = Collections.max(words, Comparator.comparing(String::length)).length();
        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, words);
        for (int i = 0; i < rotations; i++) {
            matrix = matrixRotate(matrix);
        }
        printMatrix(matrix);
    }

    private static void fillMatrix(char[][] matrix, List<String> words) {
        for (int i = 0; i < matrix.length; i++) {
            String word = words.get(i);
            for (int j = 0; j < matrix[0].length; j++) {
                if (j <= word.length() - 1){
                    matrix[i][j] = word.charAt(j);
                }else{
                    matrix[i][j] = ' ';
                }
            }
        }
    }

    private static char[][] matrixRotate(char[][] matrix) {
        int rows = matrix[0].length;
        int cols = matrix.length;
        char [][] newMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            int columnCounter = 0;
            for (int j = cols - 1; j >= 0; j--) {
                char CurrentSymbol = matrix[j][i];
                newMatrix[i][columnCounter] = CurrentSymbol;
                columnCounter++;
            }
        }
        return newMatrix;
    }private static void printMatrix(char[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
