package com.realworld.locationmanagementapi.exception;

import com.realworld.locationmanagementapi.constants.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorModel> handleBusinessException(BusinessException businessException){
        ErrorModel errorModel=new ErrorModel();
        errorModel.setErrorCode(ErrorType.AUTH_INVALID_CREDENTIALS.toString());
        errorModel.setErrorMessage("Invalid Credentials");
        return new ResponseEntity<>(errorModel,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorModel> handleEmailAlreadyExistsException(){
        ErrorModel errorModel=new ErrorModel();
        errorModel.setErrorCode(ErrorType.ALREADY_EXIST.toString());
        errorModel.setErrorMessage("Email Already Exists,Please Login");
        return new ResponseEntity<>(errorModel,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            String fieldName=error.getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        ErrorModel errorModel = new ErrorModel();
        errorModel.setErrorCode(ErrorType.VALIDATION_ERROR.toString());
        errorModel.setErrorMessage(errors.toString());
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorModel> handleGlobalException(WebRequest webRequest){
        ErrorModel errorModel=new ErrorModel();
        errorModel.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errorModel.setErrorMessage(webRequest.getDescription(false));

        return new ResponseEntity<>(errorModel,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
