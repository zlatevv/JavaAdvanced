import javax.crypto.CipherSpi;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> data = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] tokens = input.split("\\s+");
            String[] ipAddress = tokens[0].split("=");
            String[] userInfo = tokens[2].split("=");
            String ip = ipAddress[1];
            String username = userInfo[1];
            data.putIfAbsent(username, new LinkedHashMap<>());
            Map<String, Integer> ips = data.get(username);
            ips.putIfAbsent(ip, 0);
            ips.put(ip, ips.get(ip) + 1);
            input = scanner.nextLine();
        }
        data.forEach((k,v) -> {
            int count = 0;
            int size = v.size();
            System.out.println(k + ": ");
            for (Map.Entry<String, Integer> entry : v.entrySet()) {
                count++;
                if (count < size) {
                    System.out.print(entry.getKey() + " => " + entry.getValue() + ", ");
                } else {
                    System.out.println(entry.getKey() + " => " + entry.getValue() + ".");
                }
            }
        });
    }
}
