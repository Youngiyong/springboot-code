package com.giyong.es.controller;

import com.giyong.es.domain.document.store.DStore;
import com.giyong.es.domain.document.store.DStoreRepository;
import com.giyong.es.domain.entity.franchise.Franchise;
import com.giyong.es.domain.entity.franchise.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/v1/example")
@RequiredArgsConstructor
public class SampleController {

    private final FranchiseRepository franchiseRepository;

    private final DStoreRepository dStoreRepository;


    @PostConstruct
    public void tinitializing() throws ParseException {
        List<Franchise> franchiseList = franchiseRepository.findAll();

        for (Franchise franchise : franchiseList) {
            Long idx = 1L;
            String test2 = "가산 " + franchise.getName() + "|가산동 " + franchise.getName() + "|" + franchise.getName() + " " + franchise.getCategory();


            DStore dStore = DStore.builder()
                    .storeName(franchise.getName())
                    .id(idx)
                    .storeText(test2)
                    .lng(franchise.getX())
                    .lat(franchise.getY())
                    .address(franchise.getRoadAddress())
                    .build();

            dStoreRepository.save(dStore);

            idx++;
        }

    }
}