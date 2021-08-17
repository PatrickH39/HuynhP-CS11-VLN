import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // Shows initial message to player containing instructions then collects user move input.
        System.out.println("Choose rock, paper, or scissors. 'r' for rock, 'p' for paper, and 's' for scissors.");
        String playerMove = scan.next();

        // Checks if player made a selection of "r", "p", or "s".
        if(!playerMove.equals("r") && !playerMove.equals("p") && !playerMove.equals("s")) {
            System.out.println("Invalid selection, please play again.");
        } else {

            // Generates a random number.
            int randInt = (int) (Math.random() * 3);

            // Use conditions to determine the computer move based on the random number generated.
            String botMove;
            if (randInt == 0) {
                botMove = "r";
            } else if (randInt == 1) {
                botMove = "p";
            } else {
                botMove = "s";
            }

            // Compares player choice with bot choice and determines a result of win, lose, or tie.
            if (playerMove.equals(botMove)) {
                System.out.println("Draw!\n" + "Computer Choice: " + botMove + "   Player Choice: " + playerMove);
            } else if ((playerMove.equals("r")) && botMove.equals("s") || (playerMove.equals("p")) && botMove.equals("r") || (playerMove.equals("s")) && botMove.equals("p")) {
                System.out.println("You Win!\n" + "Computer Choice: " + botMove + "\tPlayer Choice: " + playerMove);
            } else {
                System.out.println("You Lose!\n" + "Computer Choice: " + botMove + "\tPlayer Choice: " + playerMove);
            }
        }
    }
}