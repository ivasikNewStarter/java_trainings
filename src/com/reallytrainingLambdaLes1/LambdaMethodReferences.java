package com.reallytrainingLambdaLes1;

import interfaces.IMovie;

/**
 * Created by u0139221 on 2/19/2020.
 */
public class LambdaMethodReferences implements IMovie{

    @Override
    public boolean check(int id) {
        return false;
    }

    // Static method reference usage
    void testMovie () {
        IMovie m1 = (x)-> x<100?true:false;
        IMovie m2 = LambdaMethodReferences::isClassic;
    }
    // Instance methods reference usage
    private void testMovieInstanceMethodRef() {
        LambdaMethodReferences ref = new LambdaMethodReferences();
        IMovie m1 = (x) -> x > 10 && x<100?true:false;
        IMovie m2 = ref::isTop;
        System.out.println(m1.check(11));
        System.out.println(m2.check(1));
    }
    private void testMovieAribaryObjectMethod() {
        IMovie m1= SomeMethodReferences::isComedy;
        m1.check(12);
    }

    private boolean isTop(int movieId) {
        return true;
    }

    static boolean isClassic (int movieId){
        return true;
    }



    public static void main(String[] args) {
        LambdaMethodReferences client = new LambdaMethodReferences();
        new LambdaMethodReferences().check(111222);
        client.testMovie();
        client.testMovieAribaryObjectMethod();
        client.testMovieInstanceMethodRef();


    }

}
class SomeMethodReferences {
    public static boolean isComedy (int i){
        return true;
    }
}
