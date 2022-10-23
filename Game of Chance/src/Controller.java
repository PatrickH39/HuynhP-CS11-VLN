// Import Libraries
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.Random;

public class Controller {

    // Welcome Screen GUI
    public VBox pageWelcome;
    public TextField textGetName;
    public Label lblNickname;
    public Button btnSubmitName;

    // The Actual Game GUI
    public Pane pageGame;

    // Balance
    public HBox hboxBal;
    public Label lblBal;

    // Question
    public Label question;
    public TextField textGetBetAmt;
    public Button btnBetYes;
    public Button btnBetNo;
    public Button btnBetEqual;

    // After user submits their choice
    public VBox vboxRolls;
    public Label lbRoll1;
    public Label lbRoll2;
    public Label lbRoll3;
    public VBox vboxResults;

    // Results
    public Label lblRollTotal;
    public Label lblStatus;
    public Button btnNextGame;

    // Initialize Private Variables
    private int bal = 5000; // Initial balance of $5000.
    private int limit; // Randomly generated number for each round within the limits of 3 dice rolls.
    private String choice; // User choice for each round. Either yes, no, or equal.
    private Boolean won = false;
    private Random r = new Random();
    private int[] rolls = new int[3];
    private int sum;

    /**
     * Requires: Nothing
     * Modifies: nickname, lblNickname, lblBal, pageWelcome, pageGame, vboxRolls, vboxResults, limit, question, alert
     * @param actionEvent
     */
    public void submitName(ActionEvent actionEvent) {

        // Initialize Variables
        String nickname = textGetName.getText(); // Sets nickname as user-inputted name.

        lblNickname.setText(nickname); // Displays name

        // Runs code if the nickname consists of alphabetical characters.
        if(nickname.matches("^[a-zA-Z ]*$") && !nickname.trim().isEmpty()) {

            // Hide welcome page
            pageWelcome.setVisible(false);

            // Show game
            pageGame.setVisible(true);
            vboxRolls.setVisible(false);
            vboxResults.setVisible(false);

            // Set initial balance
            lblBal.setText("$" + bal);
            limit = r.nextInt(11) + 4;
            question.setText("Will it add up to more than " + limit + "?");
            question.requestFocus();

        } else {
            Alert alert = new Alert(AlertType.WARNING); // Shows an alert
            alert.setTitle("Invalid Entry");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Enter a valid name!");

            alert.showAndWait();
        }
    }

    /**
     * Requires: Nothing
     * Modifies: won, amt, sum, rolls, alert, lblStatus, lbRoll1, lbRoll2, lbRoll3, lblRollTotal Bet Buttons, vboxRolls
     * Effects: Bets using the inputted amount and shows results.
     */
    private void bet(){
        // Initialize Variables
        won = false;
        String betAmt = textGetBetAmt.getText();

        // If the inputted bet amount is a number, proceed
        if (betAmt.matches("[0-9]+")) {

            int betAmtParse = Integer.parseInt(betAmt);
            // If the inputted bet amount is less than or equal to the balance, proceed.
            if(Integer.parseInt(betAmt) <= bal){

                // Loops 3 times for 3 dice amounts and adds them together.
                for(int i = 0; i < 3; i++){
                    rolls[i] = r.nextInt(5) + 1;
                    sum += rolls[i];

                    // Checks if the bets are correct.
                    if(sum > limit && choice.equals("yes")){
                        won = true;
                    } else if (sum < limit && choice.equals("no")){
                        won = true;
                    } else won = sum == limit && choice.equals("equal");
                }

                // Disable fields
                btnBetYes.setDisable(true);
                btnBetNo.setDisable(true);
                btnBetEqual.setDisable(true);
                textGetBetAmt.setDisable(true);

                // Reveal roll values
                lbRoll1.setText(String.valueOf(rolls[0]));
                lbRoll2.setText(String.valueOf(rolls[1]));
                lbRoll3.setText(String.valueOf(rolls[2]));

                vboxRolls.setVisible(true);
                lblRollTotal.setText("Total Roll Amount: " + String.valueOf(sum));

                // If the player wins, double their bet amount and add it to their balance
                // If the player loses, they lose the bet amount
                if(won){
                    lblStatus.setText("You Won!");
                    bal += betAmtParse * 2;
                } else {
                    lblStatus.setText("You Lost!");
                    bal = bal - betAmtParse;
                }

                // Updates balance
                lblBal.setText("$" + bal);

                // Show results
                vboxResults.setVisible(true);

            } else {
                // Shows an alert if the bet is higher than available balance.
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Error");

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText("You don't have enough money");
                alert.showAndWait();
            }
        } else {
            // Shows an alert if the inputted amount is not a positive number.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Check your entry.");

            alert.showAndWait();
        }
    }

    /**
     * Requires: Nothing
     * Modifies: Choice
     * Effects: Bets that the total number will be even
     *
     * @param actionEvent
     */
    public void betYes(ActionEvent actionEvent) {
        choice = "yes";
        bet();
    }

    /**
     * Requires: Nothing
     * Modifies: Choice
     * Effects: Bets that the number will be odd
     *
     * @param actionEvent
     */
    public void betNo(ActionEvent actionEvent) {
        choice = "no";
        bet();
    }

    /**
     * Requires: Nothing
     * Modifies: Choice
     * Effects: Bets that the number will be equal
     *
     * @param actionEvent
     */
    public void betEqual(ActionEvent actionEvent) {
        choice = "equal";
        bet();
    }

    /**
     * Requires: Nothing
     * Modifies: limit, sum, question, textGetBetAmt, vboxRolls, vboxResults, btnBetNo, btnBetYes, btnBetEqual, lbRoll1, lbRoll2, lbRoll3, alert
     * Effects: Creates a new bet, hides or enables certain elements.
     */
    public void newBet() {
        limit = r.nextInt(11) + 4;
        sum = 0;
        question.setText("Will it add up to more than " + limit + "?");

        // Resets the text field for betting $$$
        textGetBetAmt.setText(null);
        textGetBetAmt.setDisable(false);

        // Hides the results
        vboxRolls.setVisible(false);
        vboxResults.setVisible(false);

        // Re-enables the buttons
        btnBetNo.setDisable(false);
        btnBetYes.setDisable(false);
        btnBetEqual.setDisable(false);

        // Resets the rolls
        lbRoll1.setText("");
        lbRoll2.setText("");
        lbRoll3.setText("");
        question.requestFocus();

        // If the balance is 0, tell the user it's game over.
        if(bal == 0){
            pageGame.setVisible(false);

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("You Lost!");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("truly unfortunate. the game will now close because you have failed to create a profit :(");

            alert.showAndWait();
            Platform.exit(); // Exit game
        }

    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effect: Starts the next game
     *
     * @param actionEvent
     */
    public void nextGame(ActionEvent actionEvent) {
        newBet();
    }
}
