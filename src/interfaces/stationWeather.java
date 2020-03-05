package interfaces;

import mainObservator.readerTemp;

public interface stationWeather {

    void addReceiver(readerTemp rT);
    void deleteReceiver (readerTemp rt);
    void msg();

}
