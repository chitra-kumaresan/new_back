package com.example.SpringBootMiniProject1.exception;

//import demo.restapi.Dto.UserDto;
//import jakarta.persistence.Entity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundNameException.class)
    public ResponseEntity<ErrorDetails> HandleResourceNotFoundException(ResourceNotFoundNameException exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false),"USER_NOT_FOUND" );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> HandleException(Exception exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false),"INTERNAL_SERVER_ERROR" );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EmailAlreadyExist.class)
    public ResponseEntity<ErrorDetails> HandleEmailAlreadyExistException(EmailAlreadyExist exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false),"Employee_Email_Already_exist" );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,WebRequest request){
        Map<String,String> errors =new HashMap<>();
       List<ObjectError> objectErrors= ex.getBindingResult().getAllErrors();
       objectErrors.forEach(objectError -> {
           FieldError fieldError=(FieldError) objectError;
           errors.put(fieldError.getField(),objectError.getDefaultMessage());
       });
   return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

}
