package mainLesson13;

import java.util.Scanner;

public class bankomat {

    private BankFasade bankFasade = new BankFasade();
    private static bankomat bankomat = new bankomat();


    public static void main(String[] args) {
        bankomat.bankomatStart();
    }
    public void bankomatStart () {
        int pin = 0;
        boolean autorization = false;

        System.out.println("Hello in System");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please put pin");
        pin= sc.nextInt();

        System.out.println("Autorization....");
        autorization = bankFasade.identify(1234567890, pin);
        if (autorization) {
            bankomat.showMenu();
        }else {
            System.out.println("Please take the card.");
            bankomat.end();
        }
    }
    public void showMenu () {
        System.out.println("Menu");
        System.out.println("1. Check Bank Account");
        System.out.println("2. Give the Cash");
        System.out.println("3. End ");
        System.out.println("Choose: ");
        Scanner sc = new Scanner(System.in);
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                bankomat.checkBankAccount (1234567890);
                break;
            case 2:
                bankomat.giveCash (100);
                break;
            case 3:
                bankomat.end ();
                break;
            default:
                bankomat.showMenu();
        }
    }

    private void end() {
        System.out.println("Thank you");
        System.exit(0);


    }

    private void giveCash(int i) {
        String sum = bankFasade.giveCash(i);
        System.out.println (sum);
        System.out.println("Take a card");
        bankomat.end();
    }

    private void checkBankAccount(long nrCard) {
        System.out.println(bankFasade.checkBankAccount(nrCard));
        bankomat.showMenu();
    }


}
