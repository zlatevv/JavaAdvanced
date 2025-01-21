
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();
        String command = scanner.nextLine();
        while (!command.equals("END")){
            String[] tokens = command.split(", ");
            String c = tokens[0];
            String plate = tokens[1];
            if (c.equals("IN")){
                parkingLot.add(plate);
            }else{
                parkingLot.remove(plate);
            }
            command = scanner.nextLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String car : parkingLot){
                System.out.println(car);
            }
        }
    }
}
