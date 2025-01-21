import java.util.Arrays;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> myList = Arrays
                .stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt).sorted(Comparator.reverseOrder())
                .toList();
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
            if (i == 2){
                break;
            }
        }
    }
}
