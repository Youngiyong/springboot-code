
package com.example.point.controller;

import com.example.point.domain.sample.Franchise;
import com.example.point.domain.sample.FranchiseRepository;
import com.example.point.domain.store.Store;
import com.example.point.domain.store.StoreRepository;
import com.example.point.model.PaginationResponse;
import com.example.point.model.StoreResponse;
import com.example.point.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;


@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class StoreController {

    final FranchiseRepository franchiseRepository;
    final StoreRepository storeRepository;
    final StoreService storeService;

    @GetMapping("/store")
    public ResponseEntity<PaginationResponse> getNearStore(
            Double latitude, Double longitude, int count) {

        return new ResponseEntity<>(storeService.getNearByStore(latitude, longitude, count), HttpStatus.OK);
    }

//    @PostConstruct
//    public void tinitializing() throws ParseException {
//        List<Franchise> franchiseList = franchiseRepository.findAll();
//        int num = 0;
//        for(int i=1; i<60; i++){
//            for(int j=1; j<8; j++){
//                String pointWKT = String.format("POINT(%s %s)", franchiseList.get(num).getY(), franchiseList.get(num).getX());
//
//                // WKTReader를 통해 WKT를 실제 타입으로 변환합니다.
//                Point point = (Point) new WKTReader().read(pointWKT);
//                String test = franchiseList.get(num).getThumUrl() == null ? "" : franchiseList.get(num).getThumUrl();
//
//                Store store = Store.builder()
//                        .name(franchiseList.get(num).getName())
//                        .tel(franchiseList.get(num).getTel())
//                        .location(point)
//                        .thumbnail(test)
//                        .address(franchiseList.get(num).getAddress())
//                        .addressExtra(franchiseList.get(num).getAbbrAddress())
//                        .build();
//
//                storeRepository.save(store);
//                num++;
//            }
//        }
//    }
}
