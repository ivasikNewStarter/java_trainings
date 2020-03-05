package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class titleRegular {
    public static final String EMAIL_VERIFICATION = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    /*
                [_a-zA-Z1-9]+ - it will accept all A-Z,a-z, 0-9 and _ (+ mean it must be occur)
                (\.[A-Za-z0-9]) - it's optional which will accept . and A-Z, a-z, 0-9( * mean its optional)
                @[A-Za-z0-9]+ - it wil accept @ and A-Z,a-z,0-9
                \.[A-Za-z0-9]+ - its for . and A-Z,a-z,0-9
                (\.[A-Za-z0-9]) - it occur, . but its optional
     */

    public static final String PASSWORD_VERIFICATION = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
  /*   (    ?=.*[0-9]) a digit must occur at least once
            (?=.*[a-z]) a lower case letter must occur at least once
            (?=.*[A-Z]) an upper case letter must occur at least once
            (?=.*[@#$%^&+=]) a special character must occur at least once
            (?=\\S+$) no whitespace allowed in the entire string
            .{8,} at least 8 characters

  */

    public static void main(String[] args) {
/*      Pattern p = Pattern.compile("Java");
        Matcher m = p.matcher("Programowanie Java"); // porownywanie wzorca z matcherem
        System.out.println(m.find());  // metoda czy jest takie slowo
        System.out.println(m.matches());*/ // metoda porownania

        // ^ poczatek wzor i negacija
        // $ koniec wzorca

        // [0-9] = \\ d  cyfra
        // [^0-9] = \\D nie cyfra
        // [a-zA-Z] = \\w litera
        // [^a-zA-Z] = \\W mie litera
        // \\s = dowolny znak bialy (np. space)
        // \\S = wszystko tylko nie space
        // \\t = moze by tabulator
        // \\T = wszystko tylko nie tabulator
        // \\n = znak nowej linie
        // \. = dowolny znak

        // [a][x] = x wystapien litery a;
        // [a][1,] = [a]+ = jeden lub wieciej razy
        // [a][1,3] = [a] = minimum 1 a max 3
        // [a][0,] = [a]* = zero lub iweciej razy
        // [a]? = [a][0,1] = nie wieciej niz 1 raz


       /* Pattern p = Pattern.compile("^[0-9]{2}-[0-9]{3}$");
        Pattern p1 = Pattern.compile("^[\\d]{2}-[\\d]{3}$");// to samo co wyzej
        Matcher m =p.matcher("00-900");
        Matcher m1 =p1.matcher("00-900");
        System.out.println(m.matches());
        System.out.println(m1.matches());*/

        String[] str = {"test@google.com",
                "test.test@google.com",
                "test.test@google.com.pl",
                "test@google.com",
                "_@google.com.pl"
        };

        Pattern p = Pattern.compile(EMAIL_VERIFICATION);
        Matcher m = null;
        for (int x = 0; x < str.length; x++) {
            System.out.print(str[x] + " : ");
            m = p.matcher(str[x]);
            System.out.println(m.matches());

        }

        String[] password = {"start",
                "Starting@122",
                "start12",
                "!start123",
                "!1234start",
                "start#99"

        };
        Pattern p1 = Pattern.compile(PASSWORD_VERIFICATION);
        Matcher m1 = null;
        for (int x = 0; x < password.length; x++) {
            System.out.print(password[x] + " : ");
            m1 = p1.matcher(password[x]);
            System.out.println(m1.matches());

        }
    }

}


