package com.cbfacademy.restapiexercise.core;

import java.util.List;



public class ApiErrorResponse extends Object{


    private List<String> errors;
    private String message;

    ApiErrorResponse(){

    }

    ApiErrorResponse(List<String> errors) {
        
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


}

