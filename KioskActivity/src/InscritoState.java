import java.util.Random;

public class InscritoState implements KioskState{
    private final Kiosk kiosk;

    public InscritoState(Kiosk kiosk) {
        this.kiosk = kiosk;
    }

    public void changeState() {
        kiosk.setState(new FinalizadoState(kiosk));
    }

    public boolean validateMatricula(String matricula) throws Exception {
        throw new UnsupportedOperationException("Você já inseriu a matrícula");
    }

    public boolean validateCourse(String course) throws Exception {
        throw new UnsupportedOperationException("O curso não pode ser validado nesta etapa");
    }

    public boolean validateCreditCard(String creditCard) throws Exception {
        throw new UnsupportedOperationException("O cartão de crédito não pode ser validado nesta etapa");
    }

    public String createTicket() throws Exception {
        Random random = new Random();
        int ticketNumber = random.nextInt(1000000);
        String ticket = String.format("%06d", ticketNumber);
        return ticket;
    }
}
