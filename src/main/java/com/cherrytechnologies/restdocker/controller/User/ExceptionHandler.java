package com.cherrytechnologies.restdocker.controller.User;

import com.cherrytechnologies.restdocker.Exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> notFoundException(NotFoundException e){
               log.error("Not found Exception: " + e.getMessage());
               return ResponseEntity
                       .status(HttpStatus.BAD_REQUEST)
                       .body("Not Found");
    }
}
