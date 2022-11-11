import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Controller {
    private static final ArrayList<Friend> allFriends = new ArrayList<>();

    // Add Friend
    public TextField getFirstName;
    public TextField getLastName;
    public TextField getEmail;
    public TextField getPhoneNumber;
    public Button btnAddFriend;

    // Delete Friend
    public Button btnDeleteFriend;

    // Friend Info
    public VBox vboxFriendInfo;
    public ListView<Friend> listFriends = new ListView<>();
    public Label lblFullName;
    public Label lblEmail;
    public Label lblPhone;
    public Button btnLoad;
    public Button btnSave;

    /**
     * Requires: getFirstName, getLastName
     * Modifies: alert, Friend, getFirstName, getLastName, getEmail, getPhoneNumber
     * Effects: Adds a new friend to the friends list then updates GUI. Email/Phone are optional
     */
    public void addFriend() {
        // Form Validation
        if (getFirstName.getText().isEmpty() || getLastName.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Information");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Please check your entries");

            alert.showAndWait();
            return;
        }

        // Add Friend to List
        IOHandler.addItemAllFriends(new Friend(
                getFirstName.getText(),
                getLastName.getText(),
                getEmail.getText().isEmpty() ? "N/A" : getEmail.getText(),
                getPhoneNumber.getText().isEmpty() ? "N/A" : getPhoneNumber.getText()
        ));

        // Clear Fields
        getFirstName.clear();
        getLastName.clear();
        getEmail.clear();
        getPhoneNumber.clear();

        updateList();
    }

    /**
     * Requires: Nothing
     * Modifies: IOHandler.listFriends
     * Effects: Propagates ListView with new friends
     */
    private void updateList() {

        // Clear the list
        listFriends.getItems().clear();

        // Propagate list with friends
        for (Friend item : IOHandler.getAllFriends())
            listFriends.getItems().add(item);

        // Hide friend info if nothing is selected
        Friend selected = listFriends.getSelectionModel().getSelectedItem();
        if (selected == null) vboxFriendInfo.setVisible(false);

        listFriends.getSelectionModel().select(0);
    }

    /**
     * Requires: Nothing
     * Modifies: lblFullName, lblEmail, lblPhone, vboxFriendInfo
     * Effects: Lists available information about a friend
     *
     * @param mouseEvent
     */
    public void showFriend(MouseEvent mouseEvent) {

        if (listFriends.getItems().isEmpty()){
            vboxFriendInfo.setVisible(false);
            return;
        }

        vboxFriendInfo.setVisible(true);

        Friend selected = listFriends.getSelectionModel().getSelectedItem();

        lblFullName.setText(selected.getFirstName().toUpperCase() + " " + selected.getLastName().toUpperCase());
        lblEmail.setText(selected.getEmail());
        lblPhone.setText(selected.getPhoneNumber());
    }

    /**
     * Deletes the selected friend
     *
     * @param actionEvent
     */

    public void deleteFriend(javafx.event.ActionEvent actionEvent) {
        Friend selected = listFriends.getSelectionModel().getSelectedItem();
        IOHandler.removeItemAllFriends(selected);
        updateList();
    }

    /**
     * Saves Friends Book
     *
     * @param actionEvent
     */
    public void saveList(ActionEvent actionEvent) {
        IOHandler.writeOut();
    }

    /**
     * Loads saved Friends Book
     *
     * @param actionEvent
     */
    public void loadList(ActionEvent actionEvent) {
        IOHandler.readIn();
        updateList();
    }

}
