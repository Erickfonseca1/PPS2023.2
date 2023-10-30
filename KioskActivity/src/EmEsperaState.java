import java.util.Calendar;

public class EmEsperaState implements KioskState{
    private Kiosk kiosk;

    public EmEsperaState(Kiosk kiosk) {
        this.kiosk = kiosk;
    }

    public void changeState() {
        this.kiosk.setState(new IdentificadoState(kiosk));
    }

    @Override
    public boolean validateMatricula(String matricula) {
        // A matrícula é de um aluno do IFPB

        // Verifica se a matrícula tem 11 dígitos
        if (matricula.length() != 11) {
            return false;
        }

        // Verifica se o ano do curso é menor ou igual ao ano atual
        int anoCurso = Integer.parseInt(matricula.substring(0, 4));
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        if (anoCurso > anoAtual) {
            return false;
        }

        // Verifica se o id do curso é menor ou igual a 999
        int idCurso = Integer.parseInt(matricula.substring(4, 7));
        if (idCurso > 999) {
            return false;
        }

        // Verifica se o id do aluno é menor ou igual a 9999
        int idAluno = Integer.parseInt(matricula.substring(7, 11));
        if (idAluno > 9999) {
            return false;
        }

        BankStudents bankStudents = new BankStudents();
        kiosk.setStudent(matricula);

        if (bankStudents.getStudent(matricula) == null) {
            return false;
        } else if (bankStudents.contains(matricula)) {
            return true;
        } else {
            return false;
        }

        return true;
    }

    public boolean validateCourse(String course) throws Exception {
        throw new UnsupportedOperationException("O curso não pode ser validado nesta etapa");
    }

    public boolean validateCreditCard(String creditCard) throws Exception {
        throw new UnsupportedOperationException("O cartão de crédito não pode ser validado nesta etapa");
    }

    public String createTicket() throws Exception {
        throw new UnsupportedOperationException("O ticket não pode ser criado nesta etapa");
    }
}
