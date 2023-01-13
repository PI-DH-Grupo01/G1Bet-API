package br.com.g1bet.handler;

import br.com.g1bet.mapper.exceptions.CampoExistenteException;
import br.com.g1bet.mapper.exceptions.CampoNullException;
import br.com.g1bet.mapper.exceptions.IdNaoExisteException;
import br.com.g1bet.mapper.exceptions.SaldoInsuficienteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handlerEmailExisteException(CampoExistenteException emailExistenteException) {
        return ResponseEntity.badRequest().body(emailExistenteException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handlerSenhaNullException(CampoNullException senhaNullException) {
        return ResponseEntity.badRequest().body(senhaNullException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handlerSaldoInsuficienteException(SaldoInsuficienteException saldoInsuficienteException) {
        return ResponseEntity.badRequest().body(saldoInsuficienteException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handlerIdNaoExisteException(IdNaoExisteException idNaoExisteException) {
        return ResponseEntity.badRequest().body(idNaoExisteException.getMessage());
    }

}
