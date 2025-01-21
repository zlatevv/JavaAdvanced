import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        String path = "C:\\Users\\GRIGS\\Documents\\Java Projects\\JavaAdvanced\\Week02\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(path);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        int counter = 0;
        while (!dirs.isEmpty()){
            File currentFile = dirs.poll();
            File[] nestedFolders = currentFile.listFiles();
            assert nestedFolders != null;
            for (File file : nestedFolders){
                if (file.isDirectory()){
                    dirs.offer(file);
                }
            }
            counter++;
            System.out.println(currentFile.getName());
        }
        System.out.println(counter + " folders");
    }
}
