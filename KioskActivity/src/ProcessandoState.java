public class ProcessandoState implements KioskState{
    private final Kiosk kiosk;

    public ProcessandoState(Kiosk kiosk) {
        this.kiosk = kiosk;
    }

    public void changeState() {
        kiosk.setState( new InscritoState(kiosk));
    }

    public boolean validateMatricula(String matricula) throws Exception {
        throw new UnsupportedOperationException("A matrícula não pode ser validada nesta etapa");
    }

    public boolean validateCourse(String course) throws Exception {
        throw new UnsupportedOperationException("O curso não pode ser validado nesta etapa");
    }

    public boolean validateCreditCard(String creditCard) {
        //valida apenas se há o número de caracteres correto
        String ccValue = creditCard;
        if (ccValue.length() == 16) {
            changeState();
            return true;
        } else {
            return false;
        }
    }

    public String createTicket() throws Exception {
        throw new UnsupportedOperationException("O ticket não pode ser criado nesta etapa");
    }
}
