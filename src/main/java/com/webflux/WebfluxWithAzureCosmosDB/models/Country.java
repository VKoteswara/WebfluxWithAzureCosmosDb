package com.webflux.WebfluxWithAzureCosmosDB.models;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.lang.annotation.Documented;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "countries")
public class Country {
    @Id
    String id;
    @PartitionKey
    String countryCode;
    String countryName;
}
