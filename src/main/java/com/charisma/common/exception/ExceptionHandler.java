package com.charisma.common.exception;


import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;


@RequiredArgsConstructor
@ControllerAdvice
public abstract class ExceptionHandler {

    private final MessageSourceAccessor messageSourceAccessor;

    private static final String SAMPLE_MESSAGE_NOT_FOUND = "SAMPLE_MESSAGE_NOT_FOUND";


    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        //// TODO: 4/23/23 must be complete , that is a sample
        return new ResponseEntity<>(messageSourceAccessor.getMessage(SAMPLE_MESSAGE_NOT_FOUND), HttpStatus.BAD_REQUEST);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
        //// TODO: 4/23/23 must be complete , that is a sample
        return new ResponseEntity<>(messageSourceAccessor.getMessage(SAMPLE_MESSAGE_NOT_FOUND), HttpStatus.BAD_REQUEST);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        //// TODO: 4/23/23 must be complete , that is a sample
        return new ResponseEntity<>(messageSourceAccessor.getMessage(SAMPLE_MESSAGE_NOT_FOUND), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmptyResultDataAccessException.class)
    protected ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        //// TODO: 4/23/23 must be complete , that is a sample
        return new ResponseEntity<>(messageSourceAccessor.getMessage(SAMPLE_MESSAGE_NOT_FOUND), HttpStatus.BAD_REQUEST);
    }



}
