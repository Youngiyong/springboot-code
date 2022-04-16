package com.cheese.auth.model.response;

import com.cheese.auth.exception.ErrorCode;
import com.cheese.auth.model.message.ErrorMessage;
import com.cheese.domain.enums.EErrorActionType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@NoArgsConstructor
@JsonPropertyOrder({
        "type",
        "code",
        "message"
})
@Setter
@Getter
public class ErrorResponse {

    private EErrorActionType type;
    private String code;
    private String message;

    @Builder
    public ErrorResponse(EErrorActionType type, String code, String message){
        this.type = type;
        this.code = code;
        this.message = message;
    }

}