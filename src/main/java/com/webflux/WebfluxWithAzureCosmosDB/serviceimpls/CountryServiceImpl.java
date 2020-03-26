package com.webflux.WebfluxWithAzureCosmosDB.serviceimpls;

import com.webflux.WebfluxWithAzureCosmosDB.dtos.CountryDto;
import com.webflux.WebfluxWithAzureCosmosDB.dtos.UserDto;
import com.webflux.WebfluxWithAzureCosmosDB.exceptions.EntityNotFoundException;
import com.webflux.WebfluxWithAzureCosmosDB.mappers.CountryMapper;
import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.CountryRepository;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.StateRepository;
import com.webflux.WebfluxWithAzureCosmosDB.services.CountryService;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;
    @Override
    public Mono<Country> createCountry(Country country,Integer id) {
        return stateRepository.findById(id)
        .doOnError(error -> new EntityNotFoundException(id + " does not exist"))
                .switchIfEmpty(Mono.error(new EntityNotFoundException(id + " does not exist")))
                .map(state -> {
                    country.setState(state);
                    return  country;
                }).flatMap(country1 -> countryRepository.save(country1));
    }
    @Override
    public Flux<Country> fetchAllCountries() {
        return countryRepository.findAll();
                /*.switchIfEmpty(Mono.error(new EntityNotFoundException("No data found")))
                .map(country -> {
                            CountryDto countryDto = CountryMapper.mapper.toCountryDto(country);
                            return  countryDto;
                        })
                .cast(Country.class);*/
    }

    @Override
    public Mono<Country> updateCountryById(CountryDto countryDto, String id) {
        return countryRepository.findById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException(id +" does not exist")))
                .flatMap(country ->{
                    Country country1 = CountryMapper.mapper.toCountryForUpdate(countryDto, country);
                    return  countryRepository.save(country1);
                } ).cast(Country.class);
    }

    @Override
    public Mono<String> deleteCountryById(String id) {
        return countryRepository.findById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException(id +" does not exist")))
                .flatMap(country ->{
                    return countryRepository.delete(country).thenReturn("Deleted sucessfully");
                })
                .cast(String.class);
    }
}
