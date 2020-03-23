package com.webflux.WebfluxWithAzureCosmosDB.serviceimpls;

import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.CountryRepository;
import com.webflux.WebfluxWithAzureCosmosDB.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Mono<Country> createCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Mono<Country>> findByCountryName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }

    @Override
    public Flux<Country> fetchAllCOuntries() {
        return countryRepository.findAll();
    }
}
