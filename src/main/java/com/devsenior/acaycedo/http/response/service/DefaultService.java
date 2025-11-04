package com.devsenior.acaycedo.http.response.service;

import org.springframework.stereotype.Service;

import com.devsenior.acaycedo.http.response.dto.SumaResponse;

@Service
public class DefaultService {
    public SumaResponse suma(String num1, String num2) {
        //Creo una variable Builder
        var responseBuilder = SumaResponse.builder();
        //a la variable le sumo los dos valores captados
        responseBuilder.isError(false).value(Integer.valueOf(num1) + Integer.valueOf(num2));
        //devuelvo el resultado construido con la operacion
        return responseBuilder.build();
    }
}
