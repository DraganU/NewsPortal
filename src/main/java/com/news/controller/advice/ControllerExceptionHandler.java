package com.news.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.news.controller.exceptions.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Void> entityNotFoundException(HttpServletRequest request, EntityNotFoundException exception) {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<Void> internalServerError(HttpServletRequest request, RuntimeException exception) {
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Void> badRequestException(HttpServletRequest request,
      MethodArgumentTypeMismatchException exception) {
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

}
