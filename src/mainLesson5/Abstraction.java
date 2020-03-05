package mainLesson5;

public class Abstraction {
    public static void main(String[] args) {
        // abstraction
        triangle t = new triangle();
        t.draw();
        t.countFields();
        System.out.println(t.msg( "You draw triangle" ));
        square s= new square();
        s.draw();
        s.countFields();
        System.out.println(t.msg( "You draw square" ));

        // Polymorphism
        figure f = new triangle();
        f.draw();
        f.countFields();
        System.out.println(f.msg( "You draw duplicate" ));

    }
}
