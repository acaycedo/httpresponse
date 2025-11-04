package com.devsenior.acaycedo.http.response.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.acaycedo.http.response.dto.SumaResponse;
import com.devsenior.acaycedo.http.response.service.DefaultService;

@RestController
@RequestMapping("/api/default")
public class DefaultExceptionController {

    private final DefaultService sumaService;

    

    public DefaultExceptionController(DefaultService sumaService) {
        this.sumaService = sumaService;
    }
    //Esto tiene un problema y es que engloba las excepciones en caso que cumpla
    //Es decir si esta dentro de un Try Cath y el cath se ejecuta da error 200.
    //por lo que se completo la accion y para cambiar el http toca usar Response
    @GetMapping("/suma/{num1}/{num2}")
    public SumaResponse getSuma(@PathVariable String num1, @PathVariable String num2){
        try {
            return sumaService.suma(num1, num2);
        } catch (NumberFormatException ex) {
            return SumaResponse.builder()
            .isError(true)
            .message(ex.getMessage()+" Revisar los numeros alguno puede estar mal")
            .build();
        }
    }

    
}
