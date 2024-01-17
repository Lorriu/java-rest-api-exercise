package com.cbfacademy.restapiexercise.ious;

public class IOUNotFoundException extends RuntimeException {

        public IOUNotFoundException() {
            super("IOU not found");
        }
    
        public IOUNotFoundException(String message) {
            super(message);
        }

        //need to fix this method to do whats needed based on test?
        public String getBody() {
            return getMessage();
        }
    }
