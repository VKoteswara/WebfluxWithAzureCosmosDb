package com.webflux.WebfluxWithAzureCosmosDB.services;

import com.webflux.WebfluxWithAzureCosmosDB.dtos.UserDto;
import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import com.webflux.WebfluxWithAzureCosmosDB.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> createUser(User user,String countryNmae);
    Flux<User> fetchAllUsers();
    Mono<UserDto> findById(String id);
    Mono<User> updateUser(UserDto userDto,String id);
    Mono<String> deleteById(String id);
    Flux<UserDto> fetchAllUsersByCountryId(String id);
}
