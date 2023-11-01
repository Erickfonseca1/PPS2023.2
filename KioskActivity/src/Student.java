public class Student {
    private String student;

    public Student(String student) {
        this.student = student;
    }

    public String getStudent() {
        return this.student;
    }

    public void setStudent(String student) {
        if (  student.isEmpty() || student == null ) {
            throw new UnsupportedOperationException("A Matrícula informada é inválida");
        }
        this.student = student;
    }
}
