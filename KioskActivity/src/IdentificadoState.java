import java.util.Map;

public class IdentificadoState implements KioskState {
    private Kiosk kiosk;

    public IdentificadoState(Kiosk kiosk) {
        this.kiosk = kiosk;
    }

    public void changeState() {
        kiosk.setState(new ProcessandoState(kiosk));
    }

    public boolean validateMatricula(String matricula) throws Exception {
        throw new UnsupportedOperationException("A matrícula não pode ser validada nesta etapa");
    }

    public boolean validateCreditCard(String creditCard) throws Exception {
        throw new UnsupportedOperationException("O cartão de crédito não pode ser validado nesta etapa");
    }

    public String createTicket() throws Exception {
        throw new UnsupportedOperationException("O ticket não pode ser criado nesta etapa");
    }

    public boolean validateCourse(String course) throws Exception {
        BankCourses bankCourses = new BankCourses();
        Map<String, Courses> coursesMap = bankCourses.getCoursesMap();

        if (coursesMap.containsKey(course)) {
            if (coursesMap.get(course).getStudents().size() < coursesMap.get(course).getStudentsCapacity()) {
                // O aluno reserva uma vaga no curso (não funcionando - não é requisito)
                kiosk.setCourse(coursesMap.get(course));
                kiosk.getCourse().addStudent(kiosk.getStudent());


                changeState();
                return true;
            } else {
                throw new Exception("O curso não possui mais vagas");
            }
        } else {
            throw new Exception("O curso não é válido");
        }
    }
}
