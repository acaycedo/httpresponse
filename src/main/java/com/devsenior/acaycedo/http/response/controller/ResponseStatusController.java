package com.devsenior.acaycedo.http.response.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResponseStatusController {
    
    @ResponseStatus(code = HttpStatus.CREATED)
    @GetMapping("/created")
    public void getOk(){

    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @GetMapping("/no-content")
    public void getNoContent(){

    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @GetMapping("/bad-request")
    public void getbadRequest(){

    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @GetMapping("/not-found")
    public void getNotFound(){

    }
}
