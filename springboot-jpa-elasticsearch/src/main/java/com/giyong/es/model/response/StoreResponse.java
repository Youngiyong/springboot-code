package com.giyong.es.model.response;

import com.giyong.es.domain.document.store.DStore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class StoreResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class StoreList {
        private List<DStore> storeList;
    }


}
