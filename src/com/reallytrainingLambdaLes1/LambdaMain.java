package com.reallytrainingLambdaLes1;

import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by u0139221 on 2/17/2020.
 */
public class LambdaMain {

    public static void main(String[] args) throws IOException {

        // 1nteger Example
        System.out.println(
                IntStream
                        .range(1, 10)
                        .distinct()
                        .skip(5)
                        .sum());
        System.out.println(" ");

        // Stream Strings
        Stream.of("Ava", "Anari", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        // Stream Array
        String[] names = {"anna", "birt", "boba", "clever"};
        Arrays.stream(names) // same as Stream.of(names)
                .filter(x -> x.startsWith("b"))
                .sorted()
                .forEach(System.out::println);

        // average of squares of an int array
        Arrays.stream(new int[]{1, 2, 3, 4, 5, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        // Stream from list, filter and print
        List<String> lines = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        lines.stream()// convert list to stream
                .map(String::toLowerCase)
                .filter(line -> line.startsWith("s"))     //
                //.collect(Collectors.toList());              //
                .forEach(System.out::println);

        // The equivalent example in Java 8, stream.filter() to filter a List, and collect() to convert a stream into a List.

        List<String> lines2 = Arrays.asList("spring", "node", "mkyong");
        List<String> result = lines2.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);                //output : spring, node

        // Stream rows from txt file,sort,filter and print
     /*   Stream<String> data = Files.lines(Paths.get("plik.txt"));
        data
                .sorted()
                .filter(x->x.length()<10)
                .forEach(System.out::println);
        data.close();*/


        // 9. Stream rows from text file and save to List
        List<String> bands2 = Files.lines(Paths.get("plik.txt"))
                .filter(x -> x.contains("old"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));


        //// Stream rows from txt file and save to List
        Stream<String> data1 = Files.lines(Paths.get("data.txt"));
         int rowCount = (int) data1
                 .map(x-> x.split(","))
                 .filter(x->x.length==3)
                 .count();
        System.out.println(rowCount + "rows.");
        data1.close();

        // Stream rows from CSV file. aprse data from rows
        Stream<String> data2 = Files.lines(Paths.get("data.txt"));
        data2
                .map(x->x.split(","))
                .filter(x->x.length==3)
                .filter(x->Integer.parseInt(x[1])<15)
                .forEach(x-> System.out.println(x[0] +" "+ x[1]+" "+x[2]));
        data2.close();

        // Stream rows from CSV file, store fields in HashMap
        Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
        Map<String,Integer> map;
        map = rows3
                .map(x->x.split(","))
                .filter(x->x.length==3)
                .filter(x->Integer.parseInt(x[1])<15)
                .collect(Collectors.toMap(
                      x-> x[0],
                        x-> Integer.parseInt(x[1])));
        rows3.close();
        for (String key: map.keySet()) {
            System.out.println(key + " " + map.get(key)); // key + value
        }

        // Reduction - sum
        double total = Stream.of(7.3,1.5,4.8)
                .reduce(0.0,(Double a, Double b)-> a+b);
        System.out.printf("Total " + total);
        System.out.println();

        // reduction summary statistics

        IntSummaryStatistics summary = IntStream.of(1,2,19,88,73,4,10)
                .summaryStatistics();
        System.out.println(summary);

    }
}
