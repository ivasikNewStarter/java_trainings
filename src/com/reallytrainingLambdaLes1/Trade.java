package com.reallytrainingLambdaLes1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by u0139221 on 2/18/2020.
 */
public class Trade {

    private AtomicInteger tradeId = new AtomicInteger();

    private  int id = 0;
    private String instrument = null;
    private String status = null;
    private int quantity =0;


    public Trade(String instrument, int quantity, String status){
       setId(id);
        setQuantity(quantity);
        setStatus(status);
        setInstrument(instrument);
    }
    public Trade(int id, String instrument, int quantity, String status) {
        setId(id);
        setQuantity(quantity);
        setStatus(status);
        setInstrument(instrument);
    }


    public Trade () {
        tradeId.getAndIncrement();
    }
    public Trade (Trade t){

    }

    public AtomicInteger getTradeId() {
        return tradeId;
    }

    public void setTradeId(AtomicInteger tradeId) {
        this.tradeId = tradeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Trade [id=" + id + ", instrument=" + instrument + ", status="
                + status + ", quantity=" + quantity + "]";
    }
    public void setPrice(double price) {
        // TODO Auto-generated method stub

    }

    public boolean isOpen() {
        return true;
    }

    public boolean isBigTrade() {
        return getQuantity() > 1000000 ? true : false;
    }

    public boolean isCancelledTrade() {
        return getStatus().equals("CANCEL") ? true : false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((instrument == null) ? 0 : instrument.hashCode());
        result = prime * result + quantity;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((tradeId == null) ? 0 : tradeId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Trade other = (Trade) obj;
        if (instrument == null) {
            if (other.instrument != null)
                return false;
        } else if (!instrument.equals(other.instrument))
            return false;
        if (quantity != other.quantity)
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }


}
