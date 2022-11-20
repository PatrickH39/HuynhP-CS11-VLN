import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

class IOHandler {
    private static final ArrayList<Friend> allFriends = new ArrayList<>();
    static final FileChooser fc = new FileChooser();

    /**
     * Reads data
     *
     * Requires: Nothing
     * Modifies: allFriends
     * Effects: Add friends from data.txt
     */
    static void readIn() {
        allFriends.clear(); // Reset Friends

        try {
            // Opens a FileChooser window
            fc.setTitle("Open a file");
            File openFile = fc.showOpenDialog(null);

            // Limits to text files only
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));


            // Saves path to String path
            String path = openFile.getAbsolutePath();

            FileReader fRead = new FileReader(path);
            BufferedReader bRead = new BufferedReader(fRead);

            String line;

            while ((line = bRead.readLine()) != null) {
                String[] data = line.split("\t");

                allFriends.add(new Friend(data[0], data[1], data[2], data[3]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes data
     *
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Writes Friend List to data.txt
     */
    static void writeOut() {
        try {
            // Opens a FileChooser window
            fc.setTitle("Save a file");
            File saveFile = fc.showSaveDialog(null);

            // Limits to text files only
            fc.getExtensionFilters().clear();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            // Saves path to String path
            String path = saveFile.getAbsolutePath();

            FileWriter fWrite = new FileWriter(path, false);
            BufferedWriter bWrite = new BufferedWriter(fWrite);

            for (Friend f : allFriends) bWrite.write(f.toTSV() + "\n");

            bWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Requires: Friend
     * Modifies: allFriends
     * Effects: Adds Friend to allFriends
     *
     * @param friend Friend to add
     */
    public static void addItemAllFriends(Friend friend) {
        allFriends.add(friend);
    }

    /**
     * Requires: Friend
     * Modifies: allFriends
     * Effects: Deletes a Friend from allFriends
     *
     * @param friend Friend to delete
     */
    static void removeItemAllFriends(Friend friend) {
        allFriends.remove(friend);
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns allFriends (ArrayList)
     *
     * @return allFriends
     */
    static ArrayList<Friend> getAllFriends() {
        return allFriends;
    }

}