package com.app.web.controladores;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Lógica para manejar la excepción
        return new ResponseEntity<>("Ocurrió un error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        // Lógica para manejar una excepción específica
        return new ResponseEntity<>("No se encontró el recurso solicitado", HttpStatus.NOT_FOUND);
    }
}
