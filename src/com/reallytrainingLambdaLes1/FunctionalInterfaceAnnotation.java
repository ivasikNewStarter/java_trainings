package com.reallytrainingLambdaLes1;

/**
 * Created by u0139221 on 2/19/2020.
 */
// @FunctionalInterface Annotation
public class FunctionalInterfaceAnnotation {
    @FunctionalInterface
    interface Cruncher {
        int crunch(int i, int j);
    };
    int cruncherService (int i, int j, Cruncher cruncher){
        return cruncher.crunch(i,j);
    }

    public static void main(String[] args) {
        FunctionalInterfaceAnnotation f = new FunctionalInterfaceAnnotation();
       // int ans = f.cruncherService(3,4, (a,b)-> a*b);
        System.out.println(f.cruncherService(3,4, (a,b)-> a*b));

    }
}
