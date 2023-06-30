package br.com.belezze.belezzeAPIREST.domain;

public class ExceptionValidation extends RuntimeException {
    public ExceptionValidation(String msg) {
        super(msg);
    }
}
