package mainAnonimClass;

import interfaces.myInterface;

public class ClassAnonim {

    public static int a = 1;
    public static void main(String[] args) {
        // anonim class  + interface
        myInterface m1 = new myInterface () {

            @Override
            public void showText(String pStr) {
                System.out.println(pStr);
            }
        }; // jedna linia dlatego ":"
        // wartosci zmienne musza byc poza anonimowym lub w interface
        m1.showText("hello");
        System.out.println(m1.getClass());  // class mainAnonimClass.ClassAnonim$1 "$1" class anonim
        System.out.println(ClassAnonim.a);  // tylko static


    }
}
