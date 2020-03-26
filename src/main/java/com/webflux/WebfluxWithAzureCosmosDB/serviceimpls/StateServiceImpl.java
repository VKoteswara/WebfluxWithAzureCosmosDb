package com.webflux.WebfluxWithAzureCosmosDB.serviceimpls;

import com.webflux.WebfluxWithAzureCosmosDB.exceptions.EntityNotFoundException;
import com.webflux.WebfluxWithAzureCosmosDB.models.State;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.DistrictRepository;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.StateRepository;
import com.webflux.WebfluxWithAzureCosmosDB.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Mono<State> createState(State state,Integer id) {
        return districtRepository.findById(id)
                .doOnError(error -> new EntityNotFoundException(id + " does not exist"))
                .switchIfEmpty(Mono.error(new EntityNotFoundException(id + " does not exist")))
                .map(district -> {
                    state.setDistrict(district);
                    return  state;
                }).flatMap(state1 -> stateRepository.save(state1));
    }
}
