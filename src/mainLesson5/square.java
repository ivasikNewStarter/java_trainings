package mainLesson5;

import interfaces.interface1;

public class square extends figure implements interface1 {

    @Override
    public void draw() {
        System.out.println( "Please draw square." );

    }

    @Override
    public void countFields() {
        System.out.println( "Please count fields of square." );

    }

    @Override
    public void method1() {

    }

    @Override
    public String method2() {
        return null;
    }


}
