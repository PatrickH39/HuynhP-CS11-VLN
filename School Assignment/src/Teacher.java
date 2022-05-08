public class Teacher {
    // Initialize variables.
    private String firstName;
    private String lastName;
    private String subject;

    // Constructor for the teacher. Contains their first/last name and subjects taught.
    Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;

    }

    // Prints out the full name and subject associated to the teacher.
    public void getInfo() {
        System.out.println("Name: " + firstName + " " + lastName + "\n" + "Subject: " + subject + "\n");
    }

    // Getters and Setters (for the teacher's first/last names, and subjects taught)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
