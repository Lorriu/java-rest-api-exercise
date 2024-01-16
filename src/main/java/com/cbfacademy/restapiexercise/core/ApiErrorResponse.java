package com.cbfacademy.restapiexercise.core;

import java.util.List;



public class ApiErrorResponse extends Object{


    private List<String> errors;
    private String message;

    public ApiErrorResponse(){

    }

    public ApiErrorResponse(List<String> errors) {
        
        this.errors = errors;
    }

    public ApiErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getError() {
        return errors;
    }

    public void setError(List<String> errors) {
        
        this.errors = errors;
    }


}

