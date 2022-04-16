package com.example.point.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationResponse<T> {

    private int code = 0;
    private T data;
    private int totalCount;

    public PaginationResponse(){}

    public PaginationResponse(T data){
        this.data = data;
    }
    public PaginationResponse(T data, int count){
        this.data = data;
        this.totalCount = count;
    }


}