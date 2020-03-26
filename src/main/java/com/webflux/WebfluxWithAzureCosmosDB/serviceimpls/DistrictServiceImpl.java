package com.webflux.WebfluxWithAzureCosmosDB.serviceimpls;

import com.webflux.WebfluxWithAzureCosmosDB.models.District;
import com.webflux.WebfluxWithAzureCosmosDB.repositories.DistrictRepository;
import com.webflux.WebfluxWithAzureCosmosDB.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Override
    public Mono<District> createDistrict(District district) {
        return districtRepository.save(district);
    }
}
