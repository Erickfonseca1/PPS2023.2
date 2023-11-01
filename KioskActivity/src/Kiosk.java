import java.util.List;
import java.util.Map;

public class Kiosk {
    private KioskState currentState;
    private String student;
    private Courses course;

    BankCourses bankCourses = new BankCourses();
    BankStudents bankStudents = new BankStudents();

    public Kiosk() {
        this.currentState = new EmEsperaState(this);
    }

    public void changeState() {
        this.currentState.changeState();
    }

    public KioskState getState() {
        return this.currentState;
    }

    public void setState(KioskState state) {
        this.currentState = state;
    }

    public List<Courses> getCourses() {
        return bankCourses.getCoursesMap().entrySet().stream().map(Map.Entry::getValue).toList();
    }

    public boolean validateMatricula(String matricula) throws Exception {
        return this.currentState.validateMatricula(matricula);
    }

    public boolean validateCourse(String course) throws Exception {
        return this.currentState.validateCourse(course);
    }

    public boolean validateCreditCard(String creditCard) throws Exception {
        return this.currentState.validateCreditCard(creditCard);
    }

    public String createTicket() throws Exception {
        return this.currentState.createTicket();
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public Courses getCourse() {
        return course;
    }

    public boolean hasAvaiableCourse() {
        return bankCourses.getCoursesMap().entrySet().stream().anyMatch(course -> course.getValue().getStudents().size() < course.getValue().getStudentsCapacity());
    }
}
