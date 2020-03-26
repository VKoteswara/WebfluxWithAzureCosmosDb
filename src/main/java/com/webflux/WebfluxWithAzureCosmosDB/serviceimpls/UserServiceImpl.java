package com.webflux.WebfluxWithAzureCosmosDB.serviceimpls;

import com.webflux.WebfluxWithAzureCosmosDB.dtos.CountryDto;
import com.webflux.WebfluxWithAzureCosmosDB.dtos.UserDto;
import com.webflux.WebfluxWithAzureCosmosDB.exceptions.EntityNotFoundException;
import com.webflux.WebfluxWithAzureCosmosDB.mappers.CountryMapper;
import com.webflux.WebfluxWithAzureCosmosDB.mappers.UserMapper;
import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import com.webflux.WebfluxWithAzureCosmosDB.models.User;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.CountryRepository;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.UserRepository;
import com.webflux.WebfluxWithAzureCosmosDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Mono<User> createUser(User user,String counterName) {
        return countryRepository.findByCountryName(counterName)
                .doOnError(error -> new EntityNotFoundException(counterName + " does not exist"))
                .switchIfEmpty(Mono.error(new EntityNotFoundException(counterName + " does not exist")))
                .map(country -> {
                    System.out.println(country);
                    user.setCountry(country);
                    return user;
                })
                .flatMap(userRepository::save)
                .doOnError(error -> new EntityNotFoundException(user.getFirstName() +" is not save sucessfully"))
                .switchIfEmpty(Mono.error(new EntityNotFoundException(user.getFirstName() +" is not save sucessfully")));

    }


    @Override
    public Flux<User> fetchAllUsers() {

        return userRepository.findAll()
                /*.doOnError(error -> new EntityNotFoundException("Users are not exist"))
                .switchIfEmpty(Mono.error(new EntityNotFoundException("Users are not exist")))
                .map(user -> {
                    return UserMapper.userMapper.toUserDto(user);
                }).cast(UserDto.class)*/;
    }

    @Override
    public Mono<UserDto> findById(String id) {
        return userRepository.findById(id)
                .doOnError(error -> new EntityNotFoundException(id + " does not exist"))
                .switchIfEmpty(Mono.error(new EntityNotFoundException(id + " does not exist")))
                .map(user ->{
                    return UserMapper.userMapper.toUserDto(user);
                } ).cast(UserDto.class);
    }

    @Override
    public Mono<User> updateUser(UserDto userDto, String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException(id +" does not exist")))
                .flatMap(user -> {
                    User user1 = UserMapper.userMapper.toUserForUpdate(userDto, user);
                    //System.out.println(user1);
                    return userRepository.save(user1);
                }).cast(User.class);
    }

    @Override
    public Mono<String> deleteById(String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException(id +" does not exist")))
                .flatMap(user -> userRepository.delete(user).thenReturn("Deleted sucessfully"))
                .cast(String.class);
    }

    @Override
    public Flux<UserDto> fetchAllUsersByCountryId(String id) {
        Predicate<String> countryPredicate = str -> str.equalsIgnoreCase(id);
        return userRepository.findAll()
                .doOnError(throwable -> new EntityNotFoundException("No data found"))
                .filter(user -> {
                    Country country = Optional.ofNullable(user.getCountry()).orElse(new Country());
                    String id1 = Optional.ofNullable(country.getId()).orElse("");
                    return id1.equalsIgnoreCase(id);
                })
                .map(user ->{
                    return UserMapper.userMapper.toUserDto(user);
                } ).cast(UserDto.class);
    }
}
