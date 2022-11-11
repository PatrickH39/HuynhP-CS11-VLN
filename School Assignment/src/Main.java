import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Create DT Secondary School
        School school = new School(3939018, "David Thompson Secondary", "1755 East 55th Avenue, Vancouver, BC  V5P 1Z7");

        // Initialize arrays of students, teachers, and subjects.
        String[] studentNames = {
                "Patrick Huynh",
                "Tyler Li",
                "Terrance Wen",
                "Kevin Ma",
                "Oliver Trinh",
                "Sajjid Barcelona",
                "Malcolm Hung",
                "Edwin Lui",
                "Athan Chau",
                "Owen Turnacliff"
        };

        String[] teacherNames = {
                "Susan Leong",
                "Justin Du",
                "Deborah Macculloch"
        };

        String[] subjects = {
                "English",
                "French",
                "Chemistry",
                "Math",
                "Social Studies",
                "Physical and Health Education",
                "Computer Programming",
                "Career Life Education"
        };

        // Transform the school subjects from an array to an arraylist.
        school.setCourses(new ArrayList<>(Arrays.asList(subjects)));

        // Random number generator for grades.
        Random r = new Random();
        int minGrade = 8;
        int maxGrade = 12;

        // Goes through the student list and adds it into the school while separating their first/last names at the space then assigning a random grade.

        for(String teacherName : teacherNames) {
            school.addTeacher(new Teacher(teacherName.split(" ")[0], teacherName.split(" ")[1], subjects[r.nextInt(8)]));
        }

        for(String studentName : studentNames) {
            school.addStudent(new Student(studentName.split(" ")[0], studentName.split(" ")[1], r.nextInt(maxGrade - minGrade) + minGrade));
        }

        school.getInfo();

        // Remove one teacher.
        school.removeTeacher(school.getTeachers().get(r.nextInt(school.getTeachers().size())));

        // Remove two students.
        school.removeStudent(school.getStudents().get(r.nextInt(school.getStudents().size())));
        school.removeStudent(school.getStudents().get(r.nextInt(school.getStudents().size())));
        System.out.println("--------------------------------------------------");
        System.out.println("\033[1;31m" + "REMOVED " + "\033[0;0m" + "ONE TEACHER");
        System.out.println("\033[1;31m" + "REMOVED " + "\033[0;0m" + "TWO STUDENTS");
        System.out.println("--------------------------------------------------\n");

        System.out.println(school.getStudents());
        school.getInfo();

    }
}
