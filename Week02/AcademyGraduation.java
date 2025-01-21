import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            students.putIfAbsent(name, new ArrayList<>());
            List<Double> allGrades = students.get(name);
            for (double grade:grades){
                allGrades.add(grade);
            }
        }
        DecimalFormat df = new DecimalFormat("0.######################################");
        students.forEach((k,v) ->{
            System.out.printf("%s is graduated with %s\n", k, df.format(getAverage(v)));
        });
    }
    private static double getAverage(List<Double> grades){
        double sum = 0;
        for (double grade:grades){
            sum += grade;
        }
        return sum / grades.size();
    }
}
