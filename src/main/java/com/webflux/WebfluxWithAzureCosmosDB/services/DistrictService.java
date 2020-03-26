package com.webflux.WebfluxWithAzureCosmosDB.services;

import com.webflux.WebfluxWithAzureCosmosDB.models.District;
import reactor.core.publisher.Mono;

public interface DistrictService {
    public Mono<District> createDistrict(District district);
}
