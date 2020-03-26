package com.webflux.WebfluxWithAzureCosmosDB.mappers;

import com.webflux.WebfluxWithAzureCosmosDB.dtos.CountryDto;
import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {
    CountryMapper mapper = Mappers.getMapper(CountryMapper.class);
    CountryDto toCountryDto(Country country);
    Country toCounteryEntity(CountryDto dto);

    void toCountryForGet(Country team, @MappingTarget CountryDto teamDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Country toCountryForUpdate(CountryDto countryDto, @MappingTarget Country country);

}
