package br.com.g1bet.mapper.exceptions;

public class IdNaoExisteException extends RuntimeException {

    public IdNaoExisteException(String message) {
        super(message);
    }
}
