package com.reallytrainingLambdaLes1;

/**
 * Created by u0139221 on 2/19/2020.
 */

interface Engine {
    default String make () {
        return " Default make";
    }
}

interface Vechicle {
    default String model () {
        return " Default model";

    }
}

class Car implements Engine,Vechicle {
    String makeAndModel () {
        System.out.println(Engine.super.make() + Vechicle.super.model());
        return Engine.super.make() + Vechicle.super.model();

    }
}
// inheriting behavior from multiple interfaces
public class InheritingBehavior {
    public static void main(String[] args) {
        Car c = new Car();
        c.makeAndModel();
    }

}
