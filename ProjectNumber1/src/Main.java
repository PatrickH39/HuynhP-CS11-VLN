public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s) {

        // Goes through the string and checks for vowels (a, e, i, o, or u).
        int count = 0;

        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                count++;

        return count;
    }

    //Code you problem number two here
    static int problemTwo(String s){

        // Iterates through the string and looks for "bob".
        int count = 0;

        for(int i=0; i<s.length()-2; i++)
            if(s.substring(i, i+3).equals("bob"))
                count++;

        return count;

    }


    //Code your solution to problem number 3 here
    static String problemThree(String s){

        String currentString;
        String longestString = String.valueOf(s.charAt(0));

        // Iterates through the string and prints the longest substring of s in which the letters occur in alphabetical order.
        for(int i=0;i<s.length();i++) {

            // Sets the currentString as the character at index "i" in string "s".
            currentString = String.valueOf(s.charAt(i));

            // Iterates through the letters that are prior to the letter in currentString.
            for(int a=i+1;a<s.length();a++) {

                // Checks if the new char is the prior currentString char in alphabet.
                if((int) currentString.charAt(currentString.length()-1) <= (int) s.charAt(a)) {
                    currentString += String.valueOf(s.charAt(a));
                    continue;
                }
                break;
            }

            // If the length of currentString is longer, set that as longestString.
            if(currentString.length() > longestString.length()) longestString = currentString;
        }

        return longestString;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        problemOne("iueuaondjmhoiuxj");

    }
}
