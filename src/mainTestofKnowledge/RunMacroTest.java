package mainTestofKnowledge;

import java.io.IOException;

/**
 * Created by u0139221 on 1/28/2020.
 */
public class RunMacroTest {

    public static void main(String[] args) {
        try {

            Runtime.getRuntime().exec("C:\\Users\\u0139221\\Desktop\\myVBS.vbs");

        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
