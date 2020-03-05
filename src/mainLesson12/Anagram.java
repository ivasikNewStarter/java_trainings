package mainLesson12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Anagram {
    public static void main(String[] args) throws Exception {
        Anagram a = new Anagram();
        List<String> aList = new ArrayList <>(  );
        List<String> listAnagrams = new ArrayList <>(  );
     aList = a.readFile();
     if (aList.size()==0){
         System.out.println("File is empty");
     }else {
         System.out.println(String.format( "The file has %,d unique words", aList.size() ));
         listAnagrams = a.findAnagram( aList );
         System.out.println(String.format( "The file has %,d  anagrams", listAnagrams.size() ));
         for (String s: listAnagrams ) {
             System.out.println(s);

         }
     }
    }

    public List <String> readFile() throws Exception {
        List <String> listWord = new ArrayList <String>();
        Set <String> wordSet = new HashSet <String>();
        BufferedReader bf = new BufferedReader( new FileReader( "plik.txt" ) );
        try {
            String line;
            while ((line = bf.readLine()) != null) {
                if (line.equals( "" )) {
                    wordSet.add( line );
                }
            }
            bf.close();
            listWord.addAll( wordSet );

        } catch (Exception e) {
            System.out.println( "Something wrong with file" );
        }
        return listWord;
    }

    public List <String> findAnagram(List <String> listWord) {
        Date dStart = new Date();
        String s = "Searching anagrams";
        long totalComp = 0;
        List <String> list = new ArrayList <String>();
        System.out.print( s );

        for (int i = 0; i < listWord.size(); i++) {
            for (int j = i + 1; j < listWord.size(); j++) {
                String str1 = listWord.get( i ).toString();
                String str2 = listWord.get( j ).toString();
                totalComp++;

                if (compareTwoStrings( str1, str2 )) {
                    if ((i % 20) == 0) {
                        System.out.println( "." );
                    }
                    list.add( str1 + "-" + str2 );
                }
            }
        }
        System.out.format( "\n\nAmount of comparing %,d", totalComp );
        return list;
    }

    public boolean compareTwoStrings(String str1, String str2) {
        String aStr1 = str1.toLowerCase();
        String aStr2 = str2.toLowerCase();

        char[] c1 = aStr1.toCharArray();
        char[] c2 = aStr2.toCharArray();

        Arrays.sort( c1 );
        Arrays.sort( c1 );

        String sortStr1 = new String( c1 );
        String sortStr2 = new String( c2 );

        return sortStr1.equals( sortStr2 );

    }
}
