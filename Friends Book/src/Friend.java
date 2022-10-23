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
