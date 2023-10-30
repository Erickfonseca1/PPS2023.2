public interface KioskState {
    public void changeState();

    public boolean validateMatricula(String matricula) throws Exception;

    public boolean validateCourse(String course) throws Exception;

    public boolean validateCreditCard(String creditCard) throws Exception;

    public String createTicket() throws Exception;
}
