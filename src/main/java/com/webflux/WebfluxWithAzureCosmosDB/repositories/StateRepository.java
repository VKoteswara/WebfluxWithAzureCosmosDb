package com.webflux.WebfluxWithAzureCosmosDB.repositories;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.microsoft.azure.spring.data.cosmosdb.repository.query.ReactiveCosmosQueryExecution;
import com.webflux.WebfluxWithAzureCosmosDB.models.State;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends ReactiveCosmosRepository<State,Integer> {
}
