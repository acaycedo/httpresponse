package com.devsenior.acaycedo.http.response.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsenior.acaycedo.http.response.service.DefaultService;

@RequestMapping("/api/exception")
@RestController
public class ExceptionHandlerController {
    
    private final DefaultService sumaService;

    

    public ExceptionHandlerController(DefaultService sumaService) {
        this.sumaService = sumaService;
    }
    @GetMapping("/suma/{num1}/{num2}")
    public Integer getSuma(@PathVariable String num1, @PathVariable String num2){
            return sumaService.sumaInteger(num1, num2);
    }
    //Con esto ya no hay necesidad de hacer logica como en DefaultExceptionController
}
