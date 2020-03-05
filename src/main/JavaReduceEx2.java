package main;

/**
 * Created by u0139221 on 2/20/2020.
 */
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class JavaReduceEx2 {

    public static void main(String[] args) {
         List<Car> persons = Arrays.asList(new Car ("Skoda", 1811),
                new Car("Volvo", 22344),
                new Car("Fiat", 23650),
                new Car("Renault", 19700));

        Optional<Car> car =  persons.stream()
                .reduce((c1,c2)->c1.getPrice()> c2.getPrice()?c1:c2);
        car.ifPresent(System.out::println);

        IntStream.range(1,10).reduce((x,y)-> x+y)
          .ifPresent(s-> System.out.println(s));

        IntStream.range(1, 11).reduce(MyUtil::add2Ints)
                .ifPresent(s -> System.out.println(s));
    }

    interface MyUtil {
         static int add2Ints(int num1, int num2) {
            return num1+num2;
        }
    }
}
