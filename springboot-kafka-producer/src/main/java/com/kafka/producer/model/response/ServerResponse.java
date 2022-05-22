package com.kafka.producer.model.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonPropertyOrder({
        "status",
        "data",
        "error"
})
@AllArgsConstructor
@Setter
@Getter
public class ServerResponse<T> {

    private Boolean status;
    private T data;

    public ServerResponse(){
        this.status = true;
    }

    @Builder
    public ServerResponse(T data){
        this.status  = true;
        this.data = data;
    }

}
