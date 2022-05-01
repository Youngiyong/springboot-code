package com.giyong.es.controller;

import com.giyong.es.model.response.StoreResponse;
import com.giyong.es.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/store/search")
    public ResponseEntity<StoreResponse.StoreList> getStoreSearchList(
            @RequestParam  String name, Pageable pageable){

        return new ResponseEntity(storeService.getStoreSearchList(pageable, name), HttpStatus.OK);
    }

}
