public class Kiosk {
    private KioskState currentState;
    private Course selectedCourse;

    public Kiosk() {
        this.currentState = new EmEsperaState();
    }

    public void changeState(KioskState newState) {
        this.currentState = newState;
    }

    public void selectCourse(Course course) {
        currentState.selectCourse(this, course);
    }

    public void enterCardInfo(String cardInfo) {
        currentState.enterCardInfo(this, cardInfo);
    }

    public void generateTicket() {
        currentState.generateTicket(this);
    }
}
