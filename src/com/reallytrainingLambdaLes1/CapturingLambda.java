package com.reallytrainingLambdaLes1;

import interfaces.ITrade;

/**
 * Created by u0139221 on 2/18/2020.
 */
public class CapturingLambda implements ITrade{

    Trade trade = new Trade("IBM", 20000, "Open");


    @Override
    public boolean check(Trade t) {
        return false;
    }

    boolean isOpenTrade() {
        ITrade simpleLambda = (t)-> t.isOpen()?true:false;
        return simpleLambda.check(trade);
    }

     boolean checkStatus(String status) {
        ITrade statusLambda = (t)-> t.getStatus().equals(status)?true:false;
         return statusLambda.check(trade);

    }
    boolean isOpenAndBig (String status, int quantity){
        ITrade openAndLArgeTradeLambda = (t)->{
            return (t.getStatus().equals(status)&& t.getQuantity()> quantity)?true:false;
        };
        return openAndLArgeTradeLambda.check(trade);
    }

    public static void main(String[] args) {
        CapturingLambda cl = new CapturingLambda();
        System.out.println("Is Open Trade using non-capturinf lambda: " + cl.isOpenTrade());

    }
}
