// importing relevant libraries
import java.util.Scanner;
import java.util.Stack;

// created public class
public class Winner {

    // created public method evaluator which takes 2 arguments and evaluates the winner of RPS
    public static char evaluator (char input1, char input2) {
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

    // created public method process which takes Stack as argument
    public static void process (Stack<Character> tournamentStack) {
        // 1st contender(character) popped from top of stack
        char contender1 = tournamentStack.pop();
        // character '&' popped next from top of stack
        char operator = tournamentStack.pop();
        // 2nd contender(character) popped next from top of stack
        char contender2 = tournamentStack.pop();
        // contenders sent to evaluator method
        char winner = evaluator(contender1, contender2);
        // popping '(' from stack
        tournamentStack.pop();
        // pushing result from evaluator to stack
        tournamentStack.push(winner);
    }

    // created public method parentheses which takes String input
    public static char parentheses (String brackets) {
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
                // process method called on stack
                process(tournamentStack);
            }
            else {
                // remaining characters like 'R', 'P', 'S' pushed to stack
                tournamentStack.push(ch);
            }
        }
        // final winner of all expressions popped from stack
        return tournamentStack.pop();
    }

    // main method
    public static void main(String[] args) {
        // scanner class used
        Scanner scan = new Scanner(System.in);
        String in = scan.next();
        // winner evaluated from parentheses method
        char winner = parentheses(in);
        // final winner outputted to terminal
        System.out.println(winner);
        // closing scanner
        scan.close();
    }
}
