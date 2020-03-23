package com.webflux.WebfluxWithAzureCosmosDB.controllers;

import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import com.webflux.WebfluxWithAzureCosmosDB.services.CountryService;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/createcountry")
    public ResponseEntity<Mono<Country>> createCountry(@RequestBody Country country){

        Mono<Country> countrySaved = countryService.createCountry(country);

        return ResponseEntity.ok(countrySaved);
    }
    @GetMapping("/countries")
    public ResponseEntity<Flux<Country>> fetchCountries(){

        Flux<Country> flux = countryService.fetchAllCOuntries();

        return ResponseEntity.ok(flux);
    }
}
