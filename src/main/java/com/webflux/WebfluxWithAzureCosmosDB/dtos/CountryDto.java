package com.webflux.WebfluxWithAzureCosmosDB.dtos;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import com.webflux.WebfluxWithAzureCosmosDB.models.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryDto {

    private String id;
    private String countryCode;
    private String countryName;
    State state;
}
