package mainLesson5;

import interfaces.interface2;

public class triangle extends figure implements interface2 {
    @Override
    public void draw() {
        System.out.println( "Please draw triangle." );

    }

    @Override
    public void countFields() {
        System.out.println( "Please count fields of triangle." );
    }


    @Override
    public void method3() {
        System.out.println("this method from interface");
    }

    @Override
    public String method4() {
        return null;
    }
}
