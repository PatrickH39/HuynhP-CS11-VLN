import java.util.ArrayList;

public class School {

    // Initialize variables.
    private int schoolCode;
    private String name;
    private String address;

    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> courses = new ArrayList<>();

    // Constructor for the school. Contains the school's UID, name, and address.
    School(int schoolCode, String name, String address){
        this.schoolCode = schoolCode;
        this.name = name;
        this.address = address;
    }

    // Prints out the MyEdBC school code, school name, and address associated to the school.
    public void getInfo(){
        System.out.println("\033[1;33m" + ">>> SCHOOL DETAILS <<<" + "\033[0;0m");
        System.out.println("School Code: " + schoolCode);
        System.out.println("School Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("\n\033[1;33m" + ">>> TEACHERS <<<" + "\033[0;0m");
        listTeachers();
        System.out.println("\n\033[1;33m" + ">>> STUDENTS <<<" + "\033[0;0m");
        listStudents();
    }

    // List teachers and students
    private void listTeachers() {
        for(Teacher teacher : teachers) teacher.getInfo();
    }

    private void listStudents() {
        for(Student student : students) student.getInfo();
    }

    // Add and delete students/teachers

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
    }


    // Getters and Setters (for the array of students, teachers, and courses)
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    // Getters and Setters (for the school)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(int schoolCode) {
        this.schoolCode = schoolCode;
    }

}
