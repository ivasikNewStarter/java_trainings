package main;

import java.util.*;


public class lesson1 {
    public static void main(String[] args) {
        List <String> listStr = new ArrayList <>();
        listStr.add( "xxx" );
        listStr.add( "aaa" );
        listStr.add( "bbb" );
        for (String s : listStr) {

            System.out.println(s);

        }
        Collections.sort( listStr );
        for (String s : listStr) {

            //System.out.println(s);
        }
        Map <Integer, String> maps = new HashMap <>();
        Set <Integer> s = new HashSet <>();
        maps.put( 1, "one" );
        maps.put( 2, "two" );
        maps.put( 3, "three" );
        for (Map.Entry <Integer, String> m : maps.entrySet()) {
            int key = m.getKey();
            String value = m.getValue();
            //System.out.println(key + ":" + value);


        }
        s = maps.keySet();
        //System.out.println(s);


        Set <Integer> setStr = new HashSet <>();
        Random r = new Random();
        while (setStr.size() < 4) {
            int x = r.nextInt( 10 ) + 1;
           // System.out.println( "Show number: " + x );
            setStr.add( x );
        }
        for (Integer i : setStr) {
            //System.out.print( i );
        }

        Collection<String> myCollection = new ArrayList<String>(10);
        myCollection.add("123");
        myCollection.add("456");
        myCollection.add("789");
        for (Iterator it = myCollection.iterator(); it.hasNext();) {
            String myObject = (String)it.next();
            System.out.print(myObject + " ,");
            if (!(it.equals("456"))) {
                it.remove(); //can throw ConcurrentModificationException in single as
//well as multi-thread access situations.
                System.out.print(myCollection.toString() + " ");
            }
        }


    }
}
