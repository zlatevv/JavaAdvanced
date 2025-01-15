
import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParantheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '['){
                openBrackets.push(bracket);
            }else{
                if (!openBrackets.isEmpty()){
                    char toCheck = openBrackets.pop();
                    boolean checker = checker(toCheck, bracket);
                    if (!checker) {
                        System.out.println("NO");
                        return;
                    }

                }else{
                    System.out.println("NO");
                    return;
                }
            }


        }
        System.out.println("YES");
    }
    private static boolean checker(char openBracket, char closedBracket){
        if (openBracket == '('){
            return closedBracket == ')';
        }else if (openBracket == '{') {
            return closedBracket == '}';
        }else{
            return closedBracket == ']';
        }
    }
}
