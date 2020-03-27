package com.webflux.WebfluxWithAzureCosmosDB.serviceimpls;

import com.webflux.WebfluxWithAzureCosmosDB.exceptions.EntityNotFoundException;
import com.webflux.WebfluxWithAzureCosmosDB.models.District;
import com.webflux.WebfluxWithAzureCosmosDB.models.State;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.DistrictRepository;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.StateRepository;
import com.webflux.WebfluxWithAzureCosmosDB.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Flux<State> createState(State state,String districtName) {


        /*return  stateRepository.findByStateName(state.getStateName())
                .doOnError(error -> new EntityNotFoundException("Internal exception"))
                //.flatMap(state1 -> Mono.error(new EntityNotFoundException(state1.getStateName()+" is already exist")))
                .switchIfEmpty(Mono.defer(() -> {
                    return districtRepository.findByDistrictName(districtName)
                            .doOnError(error -> new EntityNotFoundException("Internal exception"))
                            .switchIfEmpty(Mono.error(new EntityNotFoundException(districtName + " does't exist")))
                            .map(district -> {
                                state.setDistrict(district);
                                return state; })
                            .flatMap(state1 -> stateRepository.save(state1)); }))

                .cast(State.class);*/

            return  stateRepository.findAllByStateName(state.getStateName())
                .doOnError(error -> new EntityNotFoundException("Internal exception"))
                .filter(state1 -> state1.getDistrict().getDistrictName().equals(districtName))
                .switchIfEmpty(Mono.defer(() -> {
                    return districtRepository.findByDistrictName(districtName)
                            .doOnError(error -> new EntityNotFoundException("Internal exception"))
                            .switchIfEmpty(Mono.error(new EntityNotFoundException(districtName + " does't exist")))
                            .map(district -> {
                                state.setDistrict(district);
                                return state;
                            })
                            .flatMap(state2 -> stateRepository.save(state2));

                }));
    }

}
