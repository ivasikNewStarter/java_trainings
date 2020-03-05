package mainLesson13;

public class BankLogin {

    public boolean identify (long numberCard, int pin) {
        if (numberCard == 1234567890 && pin == 1234){
            return true;
        } else {
            return false;
        }
    }


}
