public class Kiosk {
    private KioskState currentState;
    private String student;

    public Kiosk() {
        this.currentState = new EmEsperaState(this);
    }

    public void changeState() {
        this.currentState.changeState();
    }

    public KioskState getState() {
        return this.currentState;
    }

    public void setState(KioskState state) {
        this.currentState = state;
    }

}
