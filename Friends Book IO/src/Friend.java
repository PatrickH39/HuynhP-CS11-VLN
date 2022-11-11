public class Friend {

    // Friend Attributes
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;
    private final String email;

    Friend(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns a tab seperated value string
     *
     * @return Friend obj. is put in a TSV format
     */
    String toTSV() {
        return this.firstName + "\t" + this.lastName + "\t" + this.email + "\t" + this.phoneNumber;
    }

    /**
     * Requires: Nothing
     * Modifies: Nothing
     * Effects: Returns a formatted string
     *
     * @return Returns a string with full name in uppercase
     */
    @Override
    public String toString() {
        return firstName.toUpperCase() + " " + lastName.toUpperCase();
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
