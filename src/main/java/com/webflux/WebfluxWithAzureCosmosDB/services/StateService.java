package com.webflux.WebfluxWithAzureCosmosDB.services;

import com.webflux.WebfluxWithAzureCosmosDB.models.State;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StateService {
    public Flux<State> createState(State state, String districtName);
}
