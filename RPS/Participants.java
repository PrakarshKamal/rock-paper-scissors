// importing relevant libraries
import java.util.Scanner;
import java.util.Stack;

// created public class
public class Participants {

    // created public method evaluator which takes 2 arguments and evaluates the winner of RPS
    public static char evaluator(char input1, char input2) {
        // conditionals applied if both inputs are same
        if (input1 == input2) {
            return input1;
        }
        // conditionals applied if input is R&P or P&R
        else if ((input1 == 'R' && input2 == 'P') || (input1 == 'P' && input2 == 'R')) {
            return 'P';
        }
        // conditionals applied if input is R&S or S&R
        else if ((input1 == 'R' && input2 == 'S') || (input1 == 'S' && input2 == 'R')) {
            return 'R';
        }
        // conditionals applied if input is S&P or P&S
        else if ((input1 == 'S' && input2 == 'P') || (input1 == 'P' && input2 == 'S')) {
            return 'S';
        }
        // default return statement (random char used)
        return '=';
    }

    // created public class which takes stack as argument
    public static boolean process(Stack<Character> tournamentStack) {
        // conditionals applied if stack is empty
        if (tournamentStack.isEmpty()) {
            return false;
        }
        // conditionals applied if stack is empty after every instance of stack.pop
        char contender1 = tournamentStack.pop();
        if (tournamentStack.isEmpty()) {
            return false;
        }
        char operator = tournamentStack.pop();
        if (tournamentStack.isEmpty()) {
            return false;
        }
        char contender2 = tournamentStack.pop();
        if (tournamentStack.isEmpty()) {
            return false;
        }
        // conditionals applied if input is 'A' or 'B'
        if ((contender1 == 'A' || contender1 == 'B') || (contender2 == 'A' || contender2 == 'B')) {
            return false;
        }
        // contenders sent to evaluator method
        char winner = evaluator(contender1, contender2);
        // popping '(' from stack
        tournamentStack.pop();
        // pushing result from evaluator to stack
        tournamentStack.push(winner);
        // default returning true
        return true;
    }

    // created public method parentheses that takes String as input
    public static boolean parentheses(String brackets) {
        // initialized stack
        Stack<Character> tournamentStack = new Stack<>();
        // for loop applied to traverse on input string
        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);
            // conditionals applied if character is '(' or '&'
            if ((ch == '(') || (ch == '&')) {
                // characters pushed to stack
                tournamentStack.push(ch);
            }
            // conditionals applied if character is ')'
            else if (ch == ')') {
                // boolean var created and sent to process method
                boolean answer = process(tournamentStack);
                // conditionals applied on boolean var
                if (!answer) {
                    return false;
                }
            }
            // remaining characters like 'R', 'P', 'S' pushed to stack
            else {
                tournamentStack.push(ch);
            }
        }
        // returning true if stack isn't empty and size is less or equal to 2
        return (!tournamentStack.isEmpty()) && tournamentStack.size() <= 2;
    }

    // main method
    public static void main(String[] args) {
        // scanner class used
        Scanner scan = new Scanner(System.in);
        String in = scan.next();
        // boolean var created and sent to parentheses method
        boolean answer = parentheses(in);
        // conditionals applied on boolean var and printing respective validity
        if (answer) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
        }
        // closing scanner
        scan.close();
    }
}
