public interface KioskState {
    void selectCourse(Kiosk kiosk, Course course);
    void enterCardInfo(Kiosk kiosk, String cardInfo);
    void generateTicket(Kiosk kiosk);
}
