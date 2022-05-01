package com.giyong.es.model.dto;

import lombok.*;

import java.math.BigInteger;
import java.util.List;

public class StoreDto {



    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Store {
        private Long storeId;
        private String name;
        private String address;
//        private String storeText;
    }
}
