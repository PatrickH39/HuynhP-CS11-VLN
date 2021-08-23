import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Initialize win loss variables.
        int winScore = 0;
        int loseScore = 0;

        // Shows initial message to player with instructions.
        System.out.println("Enter 'r' for rock, 'p' for paper, and 's' for scissors. To exit, enter 'x'.\n" + "*".repeat(40));

        // Repeats loop until player decides to quit game.
        while (true) {

            // Collects user input.
            System.out.println("Wins: " + winScore + "\tLosses: " + loseScore + "\nPlayer's Choice:");
            String playerMove = scan.next();

            // Checks if player made a selection of 'r', 'p', 's', or 'x'.
            if (!playerMove.equals("r") && !playerMove.equals("p") && !playerMove.equals("s") && !playerMove.equals("x")) {
                System.out.println("Invalid selection, please try again.");
            } else if (playerMove.equals("x")) {
                System.out.println("Thank you for playing!");
                break;
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

                // Compares player choice with bot choice and determines a result of win, lose, or draw. Adds 1 to win lose score if applicable.
                if (playerMove.equals(botMove)) {
                    System.out.println("Draw!\n" + "Computer Choice: " + botMove + "   Player Choice: " + playerMove);
                } else if ((playerMove.equals("r")) && botMove.equals("s") || (playerMove.equals("p")) && botMove.equals("r") || (playerMove.equals("s")) && botMove.equals("p")) {
                    System.out.println("You Win!\n" + "Computer Choice: " + botMove + "\tPlayer Choice: " + playerMove);
                    winScore += 1;
                } else {
                    System.out.println("You Lose!\n" + "Computer Choice: " + botMove + "\tPlayer Choice: " + playerMove);
                    loseScore += 1;
                }
                System.out.println("*".repeat(40));
            }
        }
    }
}