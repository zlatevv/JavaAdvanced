import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        while (true){
            String name = scanner.nextLine();
            if (name.equals("stop")){
                break;
            }
            String email = scanner.nextLine();
            String[] tokens = email.split("@");
            String[] after = tokens[1].split("\\.");
            String domain = after[1];
            domain = domain.toLowerCase();
            if (domain.equals("uk") || domain.equals("us") || domain.equals("com")){
                continue;
            }else{
                emails.putIfAbsent(name, email);
            }


        }
        emails.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}
