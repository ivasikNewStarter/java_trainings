package com.reallytrainingLambdaLes1;

/**
 *  Multiple Inheritance
 */

   interface EngineN extends VechicleN{
    default String model (int id) {
        return " Default engine";
    }
}
interface VechicleN {
    default String model (int id) {
        return " Default engine";
    }
}

class CarN implements EngineN, VechicleN {
      // re-implementing the method using rule 1
       public String model (int id)
    {
        //return " Default Car";
        // Use the method from Engine using super
        return EngineN.super.model(id);
     }
    }

public class MultipleInheritance {
}
