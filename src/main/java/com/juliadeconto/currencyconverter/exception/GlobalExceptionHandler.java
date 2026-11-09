package com.juliadeconto.currencyconverter.exception;

import com.juliadeconto.currencyconverter.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidCurrency() {

        ErrorResponseDTO error = new ErrorResponseDTO(404, "Currency pair not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
