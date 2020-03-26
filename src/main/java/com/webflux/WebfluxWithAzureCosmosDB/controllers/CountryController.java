package com.webflux.WebfluxWithAzureCosmosDB.controllers;

import com.webflux.WebfluxWithAzureCosmosDB.dtos.CountryDto;
import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import com.webflux.WebfluxWithAzureCosmosDB.services.CountryService;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/createcountry")
    public ResponseEntity<Mono<Country>> createCountry(@RequestBody Country country, @RequestParam("id") Integer id){

        Mono<Country> countrySaved = countryService.createCountry(country,id);

        return ResponseEntity.ok(countrySaved);
    }
    @GetMapping("/countries")
    public ResponseEntity<Flux<Country>> fetchCountries(){

        Flux<Country> flux = countryService.fetchAllCountries();

        return ResponseEntity.ok(flux);
    }
    @PutMapping("/updateCountryByid")
    public ResponseEntity<Mono<Country>> updateCountryById(@RequestBody  CountryDto countryDto,@RequestParam("id") String id){
        return ResponseEntity.ok(countryService.updateCountryById(countryDto,id));
    }
    public ResponseEntity<Mono<String>> deletedCountryById(@RequestParam("id") String id){
        return  ResponseEntity.ok(countryService.deleteCountryById(id));
    }
}
