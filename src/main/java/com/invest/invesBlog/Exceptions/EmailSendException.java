package com.invest.invesBlog.Exceptions;

public class EmailSendException extends RuntimeException {

    public EmailSendException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public EmailSendException(String exMessage) {
        super(exMessage);
    }
}
