import java.util.Map;

public class IdentificadoState implements KioskState {
    private final Kiosk kiosk;

    public IdentificadoState(Kiosk kiosk) {
        this.kiosk = kiosk;
    }

    @Override
    public void changeState() {
        kiosk.setState(new InscritoState(kiosk));
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
