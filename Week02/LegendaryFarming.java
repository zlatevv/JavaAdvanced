import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> myDict = new TreeMap<>();
        myDict.put("shards", 0);
        myDict.put("fragments", 0);
        myDict.put("motes", 0);
        Map<String, Integer> junkItems = new TreeMap<>();
        String legendaryItem = "";
        boolean isObtained = false;

        while (!isObtained){
            String[] items = scanner.nextLine().split(" ");
            for (int i = 0; i < items.length; i += 2) {
                int value = Integer.parseInt(items[i]);
                String item = items[i + 1].toLowerCase();
                if (myDict.containsKey(item)) {
                    myDict.put(item, myDict.get(item) + value);
                    if (myDict.get(item) >= 250){
                        isObtained = true;
                        myDict.put(item, myDict.get(item) - 250);
                        switch (item){
                            case "shards" -> legendaryItem = "Shadowmourne";
                            case "fragments" -> legendaryItem = "Valanyr";
                            case "motes" -> legendaryItem = "Dragonwrath";
                        }
                        System.out.println(legendaryItem + " obtained!");
                        break;
                    }
                }else{
                    if (junkItems.containsKey(item)){
                        junkItems.put(item, junkItems.get(item) + value);
                    }else{
                        junkItems.put(item, value);
                    }
                }
            }
        }
        myDict.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        junkItems.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
