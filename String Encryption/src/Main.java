import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user for selection
        System.out.println("Enter 1 to Encrypt\nEnter 2 to Translate");

        String selection = input.nextLine();

        // Check if user selected a valid option
        if(!selection.equals("1") && !selection.equals("2")){
            System.out.println("Please select a valid option.");
        } else if(selection.equals("1")){
            // User enters a string
            System.out.println("Enter a string to be encrypted:");
            String str = input.nextLine();

            int lastIndex = str.length() - 1;
            char lastChar = str.charAt(lastIndex);
            String newStr = str.substring(0, lastIndex);

            // Takes the last character, puts it to the front, and add ay at the end
            String encryptedStr = lastChar + newStr + "ay";
            System.out.println("Encrypted String: " + encryptedStr);

        } else{
            // User enters a string
            System.out.println("Enter a string to be translated:");
            String str = input.nextLine();
            int lastIndex = str.length() - 2;
            String newStr = str.substring(1, lastIndex);

            // Removes ay from the end of the string and moves the first letter to the end
            char firstChar = str.charAt(0);
            String translatedStr = newStr + firstChar;

            System.out.println("Translated String: " + translatedStr);

        }
    }
}