package com.cheese.auth.model.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "type",
        "code",
        "message"
})
public class ErrorDto {

    @ApiModelProperty(example = "POPUP")
    private String type;

    @ApiModelProperty(example = "A0001")
    private String code;

    @ApiModelProperty(example = "Error Message")
    private String message;
}