package com.workmotion.io.peopleflow.model.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends BasicException {

    public ObjectNotFoundException(String message) {
        this.setStatusCode(HttpStatus.NOT_FOUND.value());
        this.setMsg(message);
    }

}
