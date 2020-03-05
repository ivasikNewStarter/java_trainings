package com.reallytrainingLambdaLes1;

import interfaces.Modules;

/**
 * Created by u0139221 on 2/19/2020.
 */
public class ArraysReferences implements Modules{

    @Override
    public void init() {

    }

    @Override
    public void actions() {

    }

    interface StringArray {
        String [] create (int size);
    }
    private  void testArrayConstructorReferences () {
       StringArray sArray = (size -> new String[size]);

        StringArray stringArray = String[]::new;
    }

    public static void main(String[] args) {
        Runnable runnable = () -> new ArraysReferences().testArrayConstructorReferences();
        runnable.run();
        Modules[] instances = new Modules[20];
        for (int i = 0; i < 20; i++) {
            instances[i] = new ArraysReferences() {

            };
        }


    }
}
