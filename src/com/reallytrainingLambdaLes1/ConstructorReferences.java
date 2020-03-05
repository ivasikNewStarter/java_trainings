package com.reallytrainingLambdaLes1;

import interfaces.MovieFactory;

/**
 * Created by u0139221 on 2/19/2020.
 */


public class ConstructorReferences implements MovieFactory {

    private static String message = "Private ";

    @Override
    public void sayMessage(String message) {
        System.out.println("Test");
    }

    @Override
    public String who(String m) {
        return null;
    }
    public void testing(String m) {
        System.out.println(message);
    }

    class Movie {

       // Constructor 1
       public Movie(int id){

       }
       public Movie(int id, String name){


       }
   }
    interface MovieFactory {
        Movie create (int id);
    }
    MovieFactory m1 = x-> new Movie(x);
    MovieFactory m2= Movie::new;

    interface MovieFactory2 {
        Movie create (int id, String s);
    }
    MovieFactory2 m3= Movie::new;


    public static void main(String[] args) {
          // functional interface
          new Thread (new Runnable()
          {
              @Override
              public void run() {
                  System.out.println("Run");
              }
          }).start();


        ConstructorReferences c = new ConstructorReferences();
        //MovieFactory2 m= (MovieFactory2) c.m2;
        c.who("sss");
        c.sayMessage(message);
        c.testing(message);


         }

}






