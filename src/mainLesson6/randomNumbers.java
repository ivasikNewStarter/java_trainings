package mainLesson6;
import java.util.*;
public class randomNumbers {
    public static void main(String[] args) {
Random r = new Random(  );
 String str = "123456678901234455678899";
 int lengthStr = str.length();
        System.out.println("Length of string is "+ lengthStr);
        String result= "";
        for (int i = 0; i < 10; i++) {
            int pos = r.nextInt(lengthStr);
            result = result+str.charAt( pos );

        }
        System.out.println(result);
    }
}
