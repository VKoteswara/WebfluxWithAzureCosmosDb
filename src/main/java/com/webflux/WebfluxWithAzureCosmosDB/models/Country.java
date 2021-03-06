package com.webflux.WebfluxWithAzureCosmosDB.models;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.lang.annotation.Documented;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "countries")
public class Country {
    @Id
    private String id;
    @PartitionKey
    private String countryCode;
    private String countryName;
    private State state;
}
