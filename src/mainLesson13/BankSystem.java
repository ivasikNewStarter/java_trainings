package mainLesson13;

public class BankSystem {

    public float checkBankAccount (long nrCard ) {
        if (nrCard == 1234567890 ) {
            return 350.00F;
        } else {
            return 0.00F;
        }
    }
    public String giveCash (int amount) {
        return "Amount is" + amount + "PLN";
    }
}
