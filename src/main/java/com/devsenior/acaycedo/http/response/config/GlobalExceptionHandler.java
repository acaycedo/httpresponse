package com.devsenior.acaycedo.http.response.config;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

//Esto sirve como intermediario para cuando ocurra 
//un error entre los controladores

@ControllerAdvice
public class GlobalExceptionHandler {
    //Cuando ocurra un tipo de error de estos llamar a esta funcion
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorReponse> handleRuntimeException(RuntimeException ex, HttpServletRequest request){
        var response = new ApiErrorReponse(HttpStatus.INTERNAL_SERVER_ERROR, +"Ocurrio un error inesperado "+ex.getMessage(), 
        request.getRequestURI());
        return new ResponseEntity<ApiErrorReponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<ApiErrorReponse> handleNumberException(NumberFormatException ex, HttpServletRequest request){
        var response = new ApiErrorReponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());

        return new ResponseEntity<ApiErrorReponse>(response, HttpStatus.BAD_REQUEST);
    }

    public static class ApiErrorReponse {
        private LocalDateTime timestamp;
        private Integer status;
        private String error;
        private String message;
        private String path;

        public ApiErrorReponse(HttpStatus status,String message, String path) {
            this.timestamp = LocalDateTime.now();
            this.status = status.value();
            this.error = status.getReasonPhrase();
            this.message = message;
            this.path = path;
        }
        public LocalDateTime getTimestamp() {
            return timestamp;
        }
        public Integer getStatus() {
            return status;
        }
        public String getError() {
            return error;
        }
        public String getMessage() {
            return message;
        }
        public String getPath() {
            return path;
        }
    }
    
}
