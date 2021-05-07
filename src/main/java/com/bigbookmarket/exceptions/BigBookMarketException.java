package com.bigbookmarket.exceptions;

public class BigBookMarketException extends RuntimeException {

    public BigBookMarketException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public BigBookMarketException(String exMessage) {
        super(exMessage);
    }
}