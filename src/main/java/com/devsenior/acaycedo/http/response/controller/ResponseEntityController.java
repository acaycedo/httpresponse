package com.devsenior.acaycedo.http.response.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.acaycedo.http.response.dto.SumaResponse;
import com.devsenior.acaycedo.http.response.dto.SumaResponse.SumaResponseBuilder;


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
    //Es buena practica usar un objetc en estos casos cuando tenemos datos convinados
    public ResponseEntity<SumaResponse> getSuma(@PathVariable String num1, @PathVariable String num2){
        if (num1.isBlank()) {
            return ResponseEntity.badRequest()
            .body(SumaResponse.builder()
                .isError(true)
                .message("El Primer numero esta mal")
                .build()
            );
        
        }
        if (num2.isBlank()) {
            return ResponseEntity.badRequest().
            body(SumaResponse.builder()
            .isError(true)
            .message("El Segundo numero esta mal")
            .build());
        }

        for ( var l  : num1.toCharArray()){
            if (Character.isDigit(l)){
                return ResponseEntity.badRequest()
                .body(SumaResponse.builder()
                .isError(true)
                .message("El numero 1 no es valido")
                .build());
            }
        }
        for ( var l  : num2.toCharArray()){
            if (Character.isDigit(l)){
                return ResponseEntity.badRequest()
                .body(
                    SumaResponse.builder()
                    .isError(true)
                    .message("El segundo numero no es valido")
                    .build()
                );
            }
        }
        
        return ResponseEntity.ok()
            .body(SumaResponse.builder()
                .isError(null)
                .value(Integer.valueOf(num1) + Integer.valueOf(num2))
                .build());
    }   
    
}
