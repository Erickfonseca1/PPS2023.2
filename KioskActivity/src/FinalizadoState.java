public class FinalizadoState implements KioskState{

    private final Kiosk kiosk;

    public FinalizadoState(Kiosk kiosk) {
        this.kiosk = kiosk;
    }

    public void changeState() {
        this.kiosk.setState(new EmEsperaState(kiosk));
    }

    public boolean validateMatricula(String matricula) throws Exception {
        throw new UnsupportedOperationException("A matrícula não pode ser validada nesta etapa");
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
