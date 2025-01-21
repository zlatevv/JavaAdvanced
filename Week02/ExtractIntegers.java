import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {

        String path1 = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String path2 = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        try (
                FileInputStream inputStream = new FileInputStream(path1);
                FileOutputStream outputStream = new FileOutputStream(path2)
                ) {
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
