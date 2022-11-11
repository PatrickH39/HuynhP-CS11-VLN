import java.io.*;
import java.util.ArrayList;

class IOHandler {
    private static final ArrayList<Friend> allFriends = new ArrayList<>();

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
            FileReader fRead = new FileReader("data.txt");
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
            FileWriter fWrite = new FileWriter("data.txt", false);
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
