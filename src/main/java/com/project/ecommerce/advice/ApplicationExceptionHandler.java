package com.project.ecommerce.advice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.ecommerce.exception.CustomerNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleInvalidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors()
        .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleNotFoundException(CustomerNotFoundException exception) {
        List<String> errors = Collections.singletonList(exception.getMessage());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}
