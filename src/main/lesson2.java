package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class lesson2 {
    public static void main(String[] args) throws IOException {

        String fileName = "plik.txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter( fileName );
            fileWriter.write( "Text, 1 \n" );
            fileWriter.write( "Text, 2 \n" );
            fileWriter.write( "Text, 3 \n" );
            fileWriter.write( "Text, 4 \n" );
            fileWriter.write( "Text, 5 \n" );

        } catch (IOException es) {
            System.out.println( "The file is not updated." );
        } finally {
            if (fileWriter == null) {
                System.out.println( "Problem" );
            } else {
                fileWriter.close();
            }
        }

        BufferedReader bf = null;
        try {
            bf = new BufferedReader( new FileReader( fileName ) );
            String line = null;

            do {
                line = bf.readLine();
                if (line != null) {
                    System.out.println( line );
                }

            } while (line != null);
        } catch (IOException ex) {
            System.out.println( "Prolbem with the file" );
        } finally {

                bf.close();

        }
    }
}
