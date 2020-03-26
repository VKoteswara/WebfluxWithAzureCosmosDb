package com.webflux.WebfluxWithAzureCosmosDB.repositories;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.webflux.WebfluxWithAzureCosmosDB.models.District;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends ReactiveCosmosRepository<District, Integer> {
}
