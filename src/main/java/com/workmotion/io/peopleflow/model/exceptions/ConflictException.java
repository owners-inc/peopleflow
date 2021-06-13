package com.workmotion.io.peopleflow.model.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends BasicException {

    public ConflictException(String message) {
        this.setStatusCode(HttpStatus.CONFLICT.value());
        this.setMsg(message);
    }

}
