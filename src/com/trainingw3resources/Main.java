package com.trainingw3resources;

/**
 * Created by u0139221 on 2/27/2020.
 */
public class Main {

    private int [] array1 = {1789,2035,1899,1456,2013};

    public static void main(String[] args) {
        Main m = new Main();
        int result = m.sumofInt((m.array1));
        int result1 = m.avgfInt((m.array1));
        m.containsElemetns(m.array1,2013);
        System.out.println(result1);
        System.out.println(m.containsElemetns(m.array1,2013));

    }

    public int sumofInt (int []array1){
        int sum =0;
        for (int i:array1) {
            sum +=i;
        }
        return sum;
    }
    public int avgfInt (int []array1){
        int sum =0;

        for (int i:array1) {
             sum+=i;
        }
        int avg = sum/array1.length;
        return avg;
    }

    public boolean containsElemetns (int [] array1, int a){

        for (int i : array1) {
            if (a == 2013) return true;
            else {
                continue;
            }
        }
        return false;
    }



}
