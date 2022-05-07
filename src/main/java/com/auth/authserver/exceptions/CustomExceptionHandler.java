package com.auth.authserver.exceptions;


import com.auth.authserver.domain.model.util.ApiResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponseError> runtimeExceptions(Exception ex, WebRequest request){

            ApiResponseError response = new ApiResponseError();
            response.setOk(false);
            response.setMessage(ex.getLocalizedMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
