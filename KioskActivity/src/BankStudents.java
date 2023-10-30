import java.util.ArrayList;
import java.util.List;

public class BankStudents {
    private List<String> students = new ArrayList<String>();

    BankStudents() {
        students.add("20211370030");
        students.add("20211370031");
        students.add("20211370032");
        students.add("20211370033");
        students.add("20211370034");
        students.add("20211370035");
        students.add("20211370036");
        students.add("20211370037");
        students.add("20211370038");
        students.add("20211370039");
        students.add("20211370040");
    }

    public boolean contains(String student) {
        return students.contains(student);
    }

    public List<String> getStudents() {
        return this.students;
    }

    public String getStudent(String name) {
        return this.students.get(students.indexOf(name));
    }
}
