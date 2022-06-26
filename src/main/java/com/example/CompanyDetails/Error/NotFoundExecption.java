package com.example.CompanyDetails.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExecption extends RuntimeException{
    public NotFoundExecption(){super();}
    public NotFoundExecption(String message){super(message);}

}
