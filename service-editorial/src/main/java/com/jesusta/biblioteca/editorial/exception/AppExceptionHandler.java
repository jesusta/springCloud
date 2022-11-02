package com.jesusta.biblioteca.editorial.exception;

import com.jesusta.biblioteca.editorial.dto.exception.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErrorInfo>notFountIDException(NotFoundException exc){
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;

        return builderResponseEntity(httpStatus,exc);
    }
    @ExceptionHandler
    protected ResponseEntity<ErrorInfo>invalidDataException(InvalidDataException exc){
        HttpStatus httpStatus=HttpStatus.BAD_REQUEST;

        return builderResponseEntity(httpStatus,exc);
    }

    protected ResponseEntity<ErrorInfo> builderResponseEntity(HttpStatus httpStatus , Exception ex
    ){

        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setStatus(httpStatus.value());
        errorInfo.setMessage(httpStatus.toString());
        errorInfo.setDetails(ex.getMessage());
        return new ResponseEntity<ErrorInfo> (errorInfo,httpStatus);
    }
}
