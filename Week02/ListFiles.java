import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
            File[] files = folder.listFiles();
        assert files != null;
        for (File file : files){
                if (!file.isDirectory()){
                    System.out.printf("%s: [%d]\n", file.getName(), file.length());
                }
            }
    }
}
