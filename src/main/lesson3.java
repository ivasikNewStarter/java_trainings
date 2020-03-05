package main;

import main2.class4;
import main2.class5;

public class lesson3 {
    public String publicString = "Public";
    protected String protectedString = "Protected";
    String defaultString = "Default";
    private String peivateString = "Private";
    public static String publicStringN = "Public2";

    public static void main(String[] args) {

        // modyfikatory i zasieg zmiennych
        class3 cl = new class3();
        cl.show();

        class4 c2 = new class4();
        c2.show();

        class5 c3 = new class5();
        c3.show();

    }

    public String getPeivateString() {
        return peivateString;
    }

    public void setPeivateString(String peivateString) {
        this.peivateString = peivateString;
    }
}
