import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {

        String path = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try (
                InputStream inputStream = new FileInputStream(path);
                OutputStream outputStream = new FileOutputStream(output)
                ) {
            int oneByte = inputStream.read();

            while (oneByte >= 0){
                if (oneByte == 32 || oneByte == 10){
                    outputStream.write(oneByte);
                }else{
                    String text = String.valueOf(oneByte);
                    outputStream.write(text.getBytes());
                }
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
