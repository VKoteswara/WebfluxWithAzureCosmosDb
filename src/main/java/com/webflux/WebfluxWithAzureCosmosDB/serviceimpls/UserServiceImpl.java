package com.webflux.WebfluxWithAzureCosmosDB.serviceimpls;

import com.webflux.WebfluxWithAzureCosmosDB.models.User;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.UserRepository;
import com.webflux.WebfluxWithAzureCosmosDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }
}
