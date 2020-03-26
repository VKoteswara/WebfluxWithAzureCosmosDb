package com.webflux.WebfluxWithAzureCosmosDB.repositories;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import com.webflux.WebfluxWithAzureCosmosDB.dtos.UserDto;
import com.webflux.WebfluxWithAzureCosmosDB.models.User;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCosmosRepository<User, String> {
    Mono<User> findById(String id);

    Flux<User> findAllUsersByCountryId(@Param("id") String id);
}
