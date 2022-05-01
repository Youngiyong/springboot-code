package com.giyong.es.service;

import com.giyong.es.domain.document.store.DStore;
import com.giyong.es.domain.document.store.DStoreRepository;
import com.giyong.es.model.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StoreService {

    private final DStoreRepository dStoreRepository;

    public StoreResponse.StoreList getStoreSearchList(Pageable pageable, String name){
        String[] textList = name.split(" ");

        String storeText = "";
        if(textList.length==1){
            storeText = textList[0];
        } else {
            storeText = textList[0]+" " + textList[1];
        }

        List<DStore> dStoreList = dStoreRepository.findAllByStoreTextMatchPhrasesPrefix(storeText, pageable);

        return new StoreResponse.StoreList(dStoreList);
    }
}
