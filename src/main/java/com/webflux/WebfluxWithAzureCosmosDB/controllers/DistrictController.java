package com.webflux.WebfluxWithAzureCosmosDB.controllers;

import com.webflux.WebfluxWithAzureCosmosDB.models.District;
import com.webflux.WebfluxWithAzureCosmosDB.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @PostMapping("/createdistrict")
    public ResponseEntity<Mono<District>> createDistrict(@RequestBody District district){
        return ResponseEntity.ok(districtService.createDistrict(district));
    }
}
