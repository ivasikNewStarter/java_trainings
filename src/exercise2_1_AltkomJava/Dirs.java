package exercise2_1_AltkomJava;


import java.io.File;

public class Dirs  {

    public static void main(String[] args) {
       File src = new File("src");
        ex2_1.listSubDirsOf(src);

        File home = new File(System.getProperty("user.home"));
        ex2_1.listSubDirsOf(home);


    }
}
