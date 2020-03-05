package mainObservator;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        StationWeatherN sW = new StationWeatherN( 21);
        readerTemp rt1 = new readerTemp(1);
        sW.addReceiver(rt1);
        //sW.setTemp(27);
       /* readerTemp rt2 = new readerTemp(2);
        sW.addReceiver(rt2);
        sW.setTemp(27);*/

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sW.setTemp(x);
        main(null);
    }


}
