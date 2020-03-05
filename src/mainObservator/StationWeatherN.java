package mainObservator;
import interfaces.stationWeather;

import java.util.ArrayList;
import java.util.Iterator;

public class StationWeatherN implements interfaces.stationWeather {

    ArrayList<readerTemp> recievers;
    int temp;

    public StationWeatherN(int temp) {
        recievers = new ArrayList<>();
        this.temp = temp;
    }

    @Override
    public void addReceiver(readerTemp rT) {
      recievers.add(rT);
    }

    @Override
    public void deleteReceiver(readerTemp rt) {
        recievers.remove(rt);
    }

    @Override

    // wysylaym msg
    public void msg() {
        Iterator<readerTemp> it =recievers.iterator();
        while (it.hasNext()) {
            readerTemp rt = it.next();
            rt.update(temp);
        }
    }
    //  zmiana temp
    public void setTemp (int newTemp) {
        System.out.println("New value " + newTemp);
        temp = newTemp;
        msg();
    }
}
