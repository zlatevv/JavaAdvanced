import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row1 = input[0];
        int[][] matrix1 = new int[row1][];
        matrixFill(matrix1, scanner, row1);
        int[] input2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row2 = input2[0];
        int[][] matrix2 = new int[row2][];
        matrixFill(matrix2, scanner, row2);
        if (Equal(matrix1, matrix2)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
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

    private static boolean Equal(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length){
            return false;
        }else if(matrix1[0].length != matrix2[0].length){
            return false;
        }
        else {
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    if (matrix1[i][j] != matrix2[i][j]){
                        return false;
                    }
                }
            }
        }
        return  true;
    }
}
