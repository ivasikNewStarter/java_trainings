package com.reallytrainingLambdaLes1;

/**
 * Created by u0139221 on 2/19/2020.
 */
public class FunctionalInterfaces {
    // operation is implemented using lambda expressions
    interface FuncInter1
    {
        int operation(int a, int b);
    }

    interface Multiplier {
        int multiply (int i, int j);
    };
    int operate2(int a, int b, Multiplier m)
    {
        return m.multiply(a, b);
    }


    // Performs FuncInter1's operation on 'a' and 'b'
     int operate(int a, int b, FuncInter1 fobj)
    {
        return fobj.operation(a, b);
    }

    public static void main(String[] args) {
        FuncInter1 multiply = (int x, int y) -> x * y;
        Multiplier multiplier = (a,b) -> a*b;

        FunctionalInterfaces tobj = new FunctionalInterfaces();
        System.out.println("Multiplication is " +
                tobj.operate(6, 3, multiply));
        System.out.println(" " + tobj.operate2( 2,4, multiplier));

    }
}

