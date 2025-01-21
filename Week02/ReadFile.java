import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)) {
            int oneByte = fileStream.read();

            while (oneByte >= 0){
                System.out.print(Integer.toBinaryString(oneByte) + " ");

                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
