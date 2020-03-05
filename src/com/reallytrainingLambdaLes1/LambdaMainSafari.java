package com.reallytrainingLambdaLes1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by u0139221 on 2/18/2020.
 */
public class LambdaMainSafari {

    public void methodAcceptingRunnable (Runnable r){}
    public void methodAcceptingCallable (Callable c){
        System.out.println("Hello");
    }
    private static String[] list ={"Lambda", "Lambd", "Lbda", "Lamda"};


    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(
                Arrays.asList("Hello", "world")
        );
        String s = "HelloW,HelloW,HelloW,HelloW";

        new LambdaMainSafari().joinWithPrefixPostfix(list);
        String result= joinWithPrefixPostfix(list);
        System.out.println(result);


        Runnable runnable = ()-> System.out.println("Hello");
        new LambdaMainSafari().methodAcceptingRunnable(runnable);
        new LambdaMainSafari().methodAcceptingRunnable(
                () -> {
                    System.out.println("Lambda");
                    persist();
                    email();

                });
        List<Integer> numbers = Arrays.asList(1,2,3,4,4,4,5,6,7,8,9);
        numbers
                .stream()
                .distinct()
                .forEach(x -> {
            System.out.println(x);
        });
        Callable callable = () -> "HelloW";
        new LambdaMainSafari().methodAcceptingCallable(()-> {return "Hello";});

    }


    private static void email() {
    }
    private static void persist() {}

    public static String joinWithPrefixPostfix(String[] arrayOfString){
        return Arrays.asList(arrayOfString)
                .stream()
                //.map(...)
                .collect(Collectors.joining(","));
    }

    public static List<String> split(String str){
        return Stream.of(str.split(","))
                .map (elem -> new String(elem))
                .collect(Collectors.toList());
    }

}
