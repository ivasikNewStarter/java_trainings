package mainInsideClass;

import org.w3c.dom.ls.LSOutput;

public class OutsideClass {
    public int x = 1;
    private int x1 = 2;

    public static int y = 3;
    private static int y1 = 4;

    public void testToInside() {
        System.out.println("testToInside");
        inside tO = new inside();
        tO.testToOutside();
        InsideStatic.test2();  // nie trzbea objektu
    }

    class inside {

        public void testToOutside() {
            System.out.println("testToOutside");
            System.out.println(OutsideClass.y);
            System.out.println(x);
            System.out.println("end 0f testToOutside");
            InsideStatic iS = new InsideStatic();
            iS.testNaZew();

        }
    }

    // static class
    static class InsideStatic {
        public int x = 1;
        private int x1 = 2;

        public static int y = 3;
        private static int y1 = 4;

        public void testNaZew() {
            OutsideClass z = new OutsideClass();

            System.out.println(z.x);
        }
        // staic method
        public static void test2(){

        }
    }
}
