package com.webflux.WebfluxWithAzureCosmosDB.controllers;

import com.webflux.WebfluxWithAzureCosmosDB.models.State;
import com.webflux.WebfluxWithAzureCosmosDB.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StateController {
    @Autowired
    private StateService stateService;
    @PostMapping("/createstate")
    public ResponseEntity<Flux<State>> createState(@RequestBody State state, @RequestParam("districtName") String  districtName){
        return ResponseEntity.ok(stateService.createState(state,districtName));
    }
}
