
package com.example.point.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StoreResponse {

    @ApiModelProperty(value = "Store PK", example = "1", dataType = "java.lang.Integer")
    private Integer id;

    @ApiModelProperty(value = "스토어명", example = "스토어명", dataType = "java.lang.String")
    private String name;

    @ApiModelProperty(value = "나와 매장거리", example = "200.1200000", dataType = "java.lang.Float")
    private Double distance;

    @ApiModelProperty(value = "주소", example = "주소", dataType = "java.lang.String")
    private String address;

    @ApiModelProperty(value = "썸네일", example = "https://s3.aws.com/1234.png", dataType = "java.lang.String")
    private String thumbnail;

    @ApiModelProperty(value = "위도", example = "37.4818041", dataType = "java.lang.Double")
    private Double lat;

    @ApiModelProperty(value = "경도", example = "126.882476", dataType = "java.lang.Double")
    private Double lng;
}
