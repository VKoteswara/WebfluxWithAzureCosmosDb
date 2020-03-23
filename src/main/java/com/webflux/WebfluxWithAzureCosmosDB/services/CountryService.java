package com.webflux.WebfluxWithAzureCosmosDB.services;

import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


public interface CountryService {
   Mono<Country> createCountry(Country country);
   Optional<Mono<Country>> findByCountryName(String countryName);
   Flux fetchAllCOuntries();
}
