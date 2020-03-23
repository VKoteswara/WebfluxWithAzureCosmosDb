package com.webflux.WebfluxWithAzureCosmosDB.services;

import com.webflux.WebfluxWithAzureCosmosDB.models.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> createUser(User user);
}
