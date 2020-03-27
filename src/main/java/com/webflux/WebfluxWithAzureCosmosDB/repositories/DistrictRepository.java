package com.webflux.WebfluxWithAzureCosmosDB.repositories;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.webflux.WebfluxWithAzureCosmosDB.models.District;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DistrictRepository extends ReactiveCosmosRepository<District, Integer> {
    public Mono<District> findByDistrictName(String districtName);
}
