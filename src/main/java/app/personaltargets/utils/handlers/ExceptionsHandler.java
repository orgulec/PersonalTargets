package app.personaltargets.utils.handlers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlerEntityNotFoundException(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
    }
}
