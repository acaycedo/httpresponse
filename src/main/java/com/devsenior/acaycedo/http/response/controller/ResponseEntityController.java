package com.devsenior.acaycedo.http.response.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/response-entity")
public class ResponseEntityController {
    @GetMapping("/string-list")
    public ResponseEntity<List<String>> getListString(){
        //200 Ok que solo se encarga de validar y reenviar la info
        //return ResponseEntity.ok().body(List.of("Hola","Lista","de","cadenas"));
        
        //201 Created usado para notificar de que un objeto a sido creado
        //return ResponseEntity.created(null).body(List.of("Hola","Lista","de","cadenas"));
        
        //204 todo se creo bro!(Y)
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/suma/{num1}/{num2}")
    public ResponseEntity<Integer> getSuma(@PathVariable String num1, @PathVariable String num2){
        /*if (num1.isBlank()) {
            return ResponseEntity.badRequest().body("Uno de los numeros esta en blanco");
        
        }
        if (num2.isBlank()) {
            return ResponseEntity.badRequest().body("Uno de los numeros esta en blanco");
        }
        */
        
        return ResponseEntity.ok().body(Integer.valueOf(num1) + Integer.valueOf(num2));
    }   
    
}
