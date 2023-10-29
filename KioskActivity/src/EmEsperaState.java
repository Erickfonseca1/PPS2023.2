import java.util.Calendar;

public class EmEsperaState implements KioskState{
    @Override
    public void selectCourse(Kiosk kiosk, Course course) {

    }

    @Override
    public void enterCardInfo(Kiosk kiosk, String cardInfo) {

    }

    @Override
    public void generateTicket(Kiosk kiosk) {

    }

    public Boolean validateMatricula(String matricula) {
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

        return true;
    }

}
