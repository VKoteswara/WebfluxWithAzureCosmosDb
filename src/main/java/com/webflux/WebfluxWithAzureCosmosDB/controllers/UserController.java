package com.webflux.WebfluxWithAzureCosmosDB.controllers;

import com.webflux.WebfluxWithAzureCosmosDB.exceptions.EntityNotFoundException;
import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import com.webflux.WebfluxWithAzureCosmosDB.models.User;
import com.webflux.WebfluxWithAzureCosmosDB.services.CountryService;
import com.webflux.WebfluxWithAzureCosmosDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CountryService countryService;
    @PostMapping("/createuser")
    public ResponseEntity<Mono<User>> createUser(@RequestBody User user, @RequestParam("countryName") String countryName){

        Optional<Mono<Country>> byCountryName = countryService.findByCountryName(countryName);
        byCountryName.orElseThrow(()-> new EntityNotFoundException(countryName + " is not found. please check"));
       // user.setCountry(byCountryName.get());
        Mono<User> userSaved=userService.createUser(user);
        return ResponseEntity.ok(userSaved);
    }
}
