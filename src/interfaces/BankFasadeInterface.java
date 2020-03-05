package interfaces;

public interface BankFasadeInterface {

    boolean identify (long numberCard, int pin);
    float checkBankAccount (long nrCard );
    String giveCash (int amount);
}
