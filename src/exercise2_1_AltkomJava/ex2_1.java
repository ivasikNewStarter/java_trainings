package exercise2_1_AltkomJava;


import java.io.File;
import java.io.FileFilter;

public class ex2_1 {
      public static void listSubDirsOf(File startDir) {


          FileFilter dirFilter = new FileFilter() {
              @Override
              public boolean accept(File pathname) {
                  return pathname.isDirectory();
              }
          };

          System.out.println(startDir.getAbsolutePath());

          File [] subdir = startDir.listFiles(dirFilter);
           for (File dir : subdir) {
               System.out.println(dir.getName());
           }

          System.out.printf(" Katalogs is", startDir, subdir.length);
      }
  }
