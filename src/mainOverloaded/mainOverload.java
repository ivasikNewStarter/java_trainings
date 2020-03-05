package mainOverloaded;

import mainOverloaded.methodsOverload;

public class mainOverload {

    public static void main(String[] args) {
        methodsOverload m = new methodsOverload();

        System.out.println(m.giveNUmber(2,3));
        System.out.println(m.giveNUmber(2,4));
        System.out.println(methodsOverload.giveNUmber(3,5.6));
        methodsOverload m2 = new methodsOverload();
        System.out.println(m2.a + " " + m2.b);  // private to wtedy geeters
        System.out.println(m2.getC() + " "+ m2.getD()); // private to wtedy geeters



    }


}
