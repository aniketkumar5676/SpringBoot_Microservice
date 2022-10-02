package com.check.paymentCheck.GlobalCustomException;

import com.check.paymentCheck.ExceptionHandler.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalCustomhandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(NotFound.class)
    public Map<String, String> handleInvalidUser(NotFound ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Notice: ",ex.getMessage());
        return errorMap;
    }


    /*@ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SignatureException.class)
    public Map<String, String> SignatureException(SignatureException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Notice: ",ex.getMessage());
        return errorMap;
    }*/





}
