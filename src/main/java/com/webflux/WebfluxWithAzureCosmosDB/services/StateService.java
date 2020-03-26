package com.webflux.WebfluxWithAzureCosmosDB.services;

import com.webflux.WebfluxWithAzureCosmosDB.models.State;
import reactor.core.publisher.Mono;

public interface StateService {
    public Mono<State> createState(State state,Integer id);
}
