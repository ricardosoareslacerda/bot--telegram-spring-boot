package br.com.fiap.SCJ.bottelegramspringboot.exception;

public class ActionNotSentException extends RuntimeException {

    public ActionNotSentException(String message) {
        super(message);
    }

    public ActionNotSentException(String message, Throwable cause) {
        super(message, cause);
    }

}
