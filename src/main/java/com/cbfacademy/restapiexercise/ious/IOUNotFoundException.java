package com.cbfacademy.restapiexercise.ious;

public class IOUNotFoundException extends RuntimeException {

        public IOUNotFoundException() {
            super("IOU not found");
        }
    
        public IOUNotFoundException(String message) {
            super(message);
        }
    }
