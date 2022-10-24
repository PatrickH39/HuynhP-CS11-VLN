import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // Initialize
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);

        // Read File
        String line;
        while((line = br.readLine()) != null) {
            lines.add(line);
        }

        // Call function and try it out
        System.out.println(findWord("and", lines));
    }

    /**
     *
     * Requires: word, lines
     * Modifies: Nothing
     * Effects: Returns a formatted string with lines that contain the inputted word
     *
     * @param word Word to find
     * @param lines ArrayList of lines
     * @return Formatted string
     */
    public static String findWord(String word, ArrayList<String> lines) {
        String result = "The word: " + "\033[0;1m" + word + "\u001B[0m" + ", can be found in these lines (starting from index 0): " + "\033[0;1m";
        
        // Loops through lines and adds to the end of each result.
        for (int i = 0; i < lines.size(); i++)
            if(lines.get(i).contains(word))
                result += (i + ", ");

        return result.substring(0, result.length() - 2) + "\u001B[0m.";
    }
}
