import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TreeMap<String, Integer> userDurations = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userIPs = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            userDurations.put(user, userDurations.getOrDefault(user, 0) + duration);
            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(ip);
        }
        for (String user : userDurations.keySet()) {
            int totalDuration = userDurations.get(user);
            String ipList = String.join(", ", userIPs.get(user));
            System.out.printf("%s: %d [%s]%n", user, totalDuration, ipList);
        }
    }
}
