package main;

import exceptions.myExceptions;

import java.util.Scanner;

public class lesson4 {
    public static void main(String[] args) throws myExceptions {

        // exceptopns
        lesson4 ls = new lesson4();
        ls.exceptions();
    }

    public void exceptions() throws myExceptions {
        myExceptions ms = new myExceptions();
        Scanner sc = new Scanner( System.in );
        System.out.print( "Put numbers " );
        String signs = sc.nextLine();
        if(signs.length()==0){
            System.out.println(new myExceptions( "Nothing" ) );
        }
        try {
            int x = Integer.parseInt( signs );
            System.out.println( "Number " + x );
        } catch (Exception e){
            System.out.println( new myExceptions(  "Not number" ));
            exceptions();
        }

    }
}
