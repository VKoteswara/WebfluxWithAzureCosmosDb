package com.webflux.WebfluxWithAzureCosmosDB.controllers;

import com.webflux.WebfluxWithAzureCosmosDB.dtos.CountryDto;
import com.webflux.WebfluxWithAzureCosmosDB.dtos.UserDto;
import com.webflux.WebfluxWithAzureCosmosDB.exceptions.EntityNotFoundException;
import com.webflux.WebfluxWithAzureCosmosDB.mappers.CountryMapper;
import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import com.webflux.WebfluxWithAzureCosmosDB.models.User;
import com.webflux.WebfluxWithAzureCosmosDB.services.CountryService;
import com.webflux.WebfluxWithAzureCosmosDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/createuser")
    public ResponseEntity<Mono<User>> createUser(@Valid @RequestBody User user, @RequestParam("countryName") String countryName){
        Mono<User> userSaved=userService.createUser(user,countryName);
        return ResponseEntity.ok(userSaved);
    }
    @GetMapping("/fetchalluser")
    public ResponseEntity<Flux<User>> fetchAllUsers(){

        return  ResponseEntity.ok(userService.fetchAllUsers());
    }
    @GetMapping("/fetchuserbyid")
    public  ResponseEntity<Mono<UserDto>> fetchUser(@RequestParam("id") String id){
        return  ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("updateuser")
    public ResponseEntity<Mono<User>> udateUser(@RequestBody UserDto userDto, @RequestParam("id") String id){
        return ResponseEntity.ok(userService.updateUser(userDto,id));
    }
    @DeleteMapping("/deleteuserbyid")
    public ResponseEntity<Mono<String>> deleteUser(@RequestParam("id") String id){
        return  ResponseEntity.ok(userService.deleteById(id));
    }
    @GetMapping("/fetchallusersbycountryid")
    public ResponseEntity<Flux<UserDto>> fetchAllUsersByCountryId(@RequestParam("id") String id){
        return  ResponseEntity.ok(userService.fetchAllUsersByCountryId(id));
    }
}
