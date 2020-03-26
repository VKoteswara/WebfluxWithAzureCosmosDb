package com.webflux.WebfluxWithAzureCosmosDB.controllers;

import com.webflux.WebfluxWithAzureCosmosDB.models.State;
import com.webflux.WebfluxWithAzureCosmosDB.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class StateController {
    @Autowired
    private StateService stateService;
    @PostMapping("/createstate")
    public ResponseEntity<Mono<State>> createState(@RequestBody State state,Integer id){
        return ResponseEntity.ok(stateService.createState(state,id));
    }
}
