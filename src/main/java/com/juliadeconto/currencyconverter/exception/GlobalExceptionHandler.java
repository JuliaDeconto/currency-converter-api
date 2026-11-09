package com.juliadeconto.currencyconverter.exception;

import com.juliadeconto.currencyconverter.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidCurrency() {

        ErrorResponseDTO error = new ErrorResponseDTO(404, "Currency pair not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidAmount() {

        ErrorResponseDTO error = new ErrorResponseDTO(400, "Invalid amount: must be a number");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponseDTO> handleMissingParam() {

        ErrorResponseDTO error = new ErrorResponseDTO(400, "Missing required parameter");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
