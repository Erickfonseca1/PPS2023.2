import java.util.ArrayList;
import java.util.List;

public class Courses {
    private String name;
    private Double price;
    private final int studentsCapacity = 10;
    private final List<String> students = new ArrayList<String>();

    public Courses(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getStudentsCapacity() {
        return this.studentsCapacity;
    }

    public boolean addStudent(String student) {
        if (students.size() < studentsCapacity) {
            students.add(student);
            return true;
        }
        return false;
    }

    public List<String> getStudents() {
        return this.students;
    }
}
