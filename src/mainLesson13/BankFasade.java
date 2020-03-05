package mainLesson13;


import interfaces.BankFasadeInterface;

public class BankFasade implements BankFasadeInterface {

     private BankSystem bankSystem;
     private BankLogin bankLogin;

     public  BankFasade () {
         bankSystem = new BankSystem();
         bankLogin = new BankLogin();
     }
    @Override
    public boolean identify(long numberCard, int pin) {
         boolean correct = false;
         correct = bankLogin.identify(numberCard,pin);
        return correct;
    }

    @Override
    public float checkBankAccount(long nrCard) {
         float sumAccount = 0.00F;
         sumAccount = bankSystem.checkBankAccount(nrCard);
        return sumAccount;
    }

    @Override
    public String giveCash(int amount) {

        return bankSystem.giveCash(amount);
    }
}
