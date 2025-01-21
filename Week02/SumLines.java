import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class SumLines {
    public static void main(String[] args) throws IOException {

        String inputPath = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        List<String> allFiles = Files.readAllLines(Path.of(inputPath));
        allFiles
                .stream()
                .map(String::toCharArray)
                .forEach(arr -> {
                    int sum = 0;
                    for (char symbol : arr){
                        sum += symbol;
                    }
                    System.out.println(sum);
        });
    }
}
