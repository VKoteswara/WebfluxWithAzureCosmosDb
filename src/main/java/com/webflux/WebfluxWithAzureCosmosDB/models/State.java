package com.webflux.WebfluxWithAzureCosmosDB.models;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "state")
public class State {
    @Id
    private String id;
    @PartitionKey
    private String stateCode;
    private String stateName;
    private District district;
}
