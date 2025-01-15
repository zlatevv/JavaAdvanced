import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        int[][] matrix = new int[size][size];
        String pattern = input[1];
        if (pattern.equals("A")){
            matrixFillPatternA(matrix, size);
        }else{
            matrixFillPatternB(matrix, size);
        }
        printMatrix(matrix);
    }



    private static void matrixFillPatternB(int[][] matrix, int size) {
        int counter = 1;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < size; j++) {
                    matrix[j][i] = counter++;
                }
            }else{
                for (int j = size - 1; j >= 0; j--) {
                    matrix[j][i] = counter++;
                }
            }
        }
    }

    private static void matrixFillPatternA(int[][] matrix, int size) {
        int counter = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[j][i] = counter++;

            }
        }
    }private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
