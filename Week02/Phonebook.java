import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("search")){
            String[] tokens = command.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phonebook.putIfAbsent(name, number);
            if (phonebook.containsKey(name)){
                phonebook.put(name, number);
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("stop")){
            if (phonebook.containsKey(command)){
                System.out.println(command + " -> " + phonebook.get(command));
            }else{
                System.out.printf("Contact %s does not exist.\n", command);
            }
            command = scanner.nextLine();
        }
    }
}
