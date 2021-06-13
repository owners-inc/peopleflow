package com.workmotion.io.peopleflow.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicResponse {

    public BasicResponse(){
    }

    public BasicResponse(Object data,Integer totalCount, Integer statusCode) {
        this.totalCount = totalCount;
        this.data = data;
        this.statusCode = statusCode;
    }

    private Integer totalCount;
    private Object data;
    private Integer  statusCode;
}
