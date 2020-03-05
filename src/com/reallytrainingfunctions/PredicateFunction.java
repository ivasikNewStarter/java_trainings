package com.reallytrainingfunctions;

/**
 * Created by u0139221 on 2/19/2020.
 */
import java.util.function.Predicate;
public class PredicateFunction {
     @FunctionalInterface
     public interface Predicate<T> {
         // single abstract method
         boolean test (T t);
         // .. other methods such as and, or & negate
     }

   // Predicate<Employee> bonusLambda = (emp)->em

    public static void main(String[] args) {

    }
}
