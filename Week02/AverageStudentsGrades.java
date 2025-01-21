
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> grades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            grades.putIfAbsent(name, new ArrayList<>());
            List<Double> All = grades.get(name);
            All.add(grade);
        }
        grades.forEach((k, v) -> {
            System.out.printf(k + " -> ");
            v.forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)\n", getAverage(v));
        });
    }

    private static double getAverage(List<Double> v) {
        double sum = 0;
        for (double num : v){
            sum += num;
        }
        return sum / v.size();
    }
}
