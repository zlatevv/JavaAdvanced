import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";
        String outputPath = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";


        try (
                InputStream inputStream = new FileInputStream(path);
                OutputStream outputStream = new FileOutputStream(outputPath);

                ){
            int oneByte = inputStream.read();

            while (oneByte >= 0){
                char symbol = (char) oneByte;

                if (symbol != ',' && symbol != '.' && symbol != '?' && symbol != '!'){
                    outputStream.write(symbol);
                }

                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
