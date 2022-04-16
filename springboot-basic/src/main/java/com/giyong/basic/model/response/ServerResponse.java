package com.cheese.auth.model.response;

import com.cheese.domain.enums.EErrorActionType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.time.ZonedDateTime;

@JsonPropertyOrder({
        "status",
        "data",
        "error"
})
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AuthServerResponse<T> {

    private Boolean status;
    private T data;
    private ErrorResponse error;

    @Builder
    public AuthServerResponse(T data){
        this.status = true;
        this.data = data;
    }

    public AuthServerResponse(ErrorResponse error){
        this.status = false;
        this.error = error;
    }

}
