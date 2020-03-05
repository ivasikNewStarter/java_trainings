package mainLesson7;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class strumenia {
    public static void main(String[] args) {

        List <mieszkanie> mList = Arrays.asList(
                new mieszkanie( "Warsaw ", " Saska", " Bosman ", 3, 6.03f, true, 400000 ),
                new mieszkanie( "Cracow ", " Saska", " Bosman ", 3, 6.03f, true, 400000 ),
                new mieszkanie( "Gdansk ", " Saska", " Bosman ", 3, 6.03f, true, 400000 ),
                new mieszkanie( "Gdynia ", " Saska", " Bosman ", 3, 6.03f, true, 400000 )

        );
        // lambda
        // stream -- search
        // map pokaz dane
        // for each dla kazdego

        mList.stream()
                .filter( mieszkanie -> mieszkanie.getCity().equals("Cracow "))
                 .filter(mieszkanie -> mieszkanie.getPrice() < 500000 )
        .map(mieszkanie -> mieszkanie.getCity() + " "+ mieszkanie.getPrice()
        + mieszkanie.getStreet())
        .forEach( System.out :: println);

        // Predicate warunek wstepny
        // stream()
        // filter
        // collect

        Predicate<mieszkanie> mName = m -> m.getCity().equals( "Cracow" );
        List<mieszkanie> list = new ArrayList <mieszkanie>( );
        list = mList.stream()
                .filter( mName )
                .collect( Collectors.toList());
        System.out.println(list);

        /*mList.stream()
                .filter( mieszkanie -> mieszkanie.getCity().equals( "Gdynia" ))
                .filter(mieszkanie -> mieszkanie.getRooms()>1 )
                .filter( mieszkanie -> mieszkanie.getPrice()<500000 )
                .map( mieszkanie -> mieszkanie.getCity()+" "+ mieszkanie.getStreet()
                + mieszkanie.getPrice())
                .forEach( System.out::println );



        Predicate<mieszkanie> mName = m -> m.getCity().equals( "Cracow" );
        List<mieszkanie> list = new ArrayList <mieszkanie>( );
        list = mList.stream()
                .filter( mName )
                .collect( Collectors.toList());
        System.out.println(list);*/






    }
}
