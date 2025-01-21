import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String path1 = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String path2 = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        try (
                InputStream inputStream = new FileInputStream(path1);
                OutputStream outputStream = new FileOutputStream(path2);
                ){

            Scanner scanner = new Scanner(inputStream);
            int counter = 0;
            while (scanner.hasNextLine()){
                counter++;
                String currentLine = scanner.nextLine();
                if (counter % 3 == 0) {
                    outputStream.write((currentLine + System.lineSeparator()).getBytes());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
