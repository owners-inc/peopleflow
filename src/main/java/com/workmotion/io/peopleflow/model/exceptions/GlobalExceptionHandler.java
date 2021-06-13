package com.workmotion.io.peopleflow.model.exceptions;

import com.workmotion.io.peopleflow.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoRecordFoundException(ObjectNotFoundException o)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(o.getMsg());
        errorResponse.setStatusCode(o.getStatusCode());
        return errorResponse;
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleConflictException(ConflictException c)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(c.getMsg());
        errorResponse.setStatusCode(c.getStatusCode());
        return errorResponse;
    }

    @ExceptionHandler(BasicException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleBasicException(BasicException be)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(be.getMsg());
        errorResponse.setStatusCode(be.getStatusCode());
        return errorResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInternalServerException(Exception ex)
    {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return errorResponse;
    }


}
