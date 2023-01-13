package br.com.g1bet.mapper.exceptions;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String message) {
        super(message);
    }

}
