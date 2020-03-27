package com.webflux.WebfluxWithAzureCosmosDB.serviceimpls;

import com.webflux.WebfluxWithAzureCosmosDB.exceptions.EntityNotFoundException;
import com.webflux.WebfluxWithAzureCosmosDB.models.District;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.DistrictRepository;
import com.webflux.WebfluxWithAzureCosmosDB.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Predicate;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Mono<District> createDistrict(District district) {
        return districtRepository.findByDistrictName(district.getDistrictName())
                                 .doOnError(error -> new EntityNotFoundException(district.getDistrictName() + "does't exist"))
                                 .flatMap(district1 -> Mono.error(new EntityNotFoundException(district1.getDistrictName()+" is aleady exist")))
                                 .switchIfEmpty( districtRepository.save(district))
                                 .doOnError(error -> new EntityNotFoundException(district.getDistrictName() + "does't save"))
                                 .cast(District.class);
    }
}
