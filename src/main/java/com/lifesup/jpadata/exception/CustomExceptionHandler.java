package com.lifesup.jpadata.exception;

import com.lifesup.jpadata.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DispenseException.class)
    public ResponseEntity<ApiResponse<String>> handleCustomException(DispenseException ex) {
        ApiResponse<String> response = new ApiResponse<>(500, ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponse<List<String>> handleNoRecordFoundException(RecordNotFoundException ex)
    {
        ApiResponse<List<String>> errorResponse = new ApiResponse<>();
        errorResponse.setMessage("No Record Found");
        return errorResponse;
    }

}
