public class Student {
    // Create a counter for incrementing the ID's.
    private static int count = 1;

    // Initialize variables.
    private String firstName;
    private String lastName;
    private int grade;
    private int id = count;

    // Constructor for the student. Contains their first/last name, grade, and increments ID by 1 each new student created.
    Student(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        count++;
    }

    // Prints out the full name and grade associated to the student.
    public void getInfo() {
        System.out.println("Name: " + firstName + " " + lastName + "\n" + "Grade: " + grade + "\n");
    }

    // Getters and Setters (for the student's first/last name, grade, and student number)

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
