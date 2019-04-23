package br.senai.sc.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.senai.sc.services.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ObjetoNaoEncontradoException> objetoNaoEncontrado(ObjetoNaoEncontradoException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
	}

}
