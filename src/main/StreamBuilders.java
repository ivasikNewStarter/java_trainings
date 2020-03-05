package main;

import interfaces.Email;

import java.util.stream.Stream;

/**
 * Created by u0139221 on 2/18/2020.
 */
public class StreamBuilders implements Email{
     public  String getEmail (String name, Email email){
         return null;
     }
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(new Integer[]{1,2,3,4,5,6,7,8});
        s.forEach(x-> System.out.println(x));

        new StreamBuilders().getEmail("iwan",(String name)-> name + "@com.");
    }

    Email email = (String name)-> name + "@com.";

    @Override
    public String constructEmail(String name) {
        return null;
    }
}
