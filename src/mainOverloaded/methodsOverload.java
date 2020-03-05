package mainOverloaded;

public class methodsOverload {
    int a = 33;
    int b = 31;

    private int c = 22;
    private int d = 22;

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public methodsOverload (int a) {
        this.a = a;
    }

    public methodsOverload (int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void giveNUmber (int a) {
        System.out.println("No number");

    }
    public double giveNUmber (double a) {
        return a;  // musi byc inny argument

    }

    public  int giveNUmber(int a, int b) {
      return a;  // musi byc inny argument

    }

    public static int giveNUmber (int a, double b) {
        int sum = a+(int)b;
        return sum;

    }

    public methodsOverload() {

    }



}
