package com.webflux.WebfluxWithAzureCosmosDB.dtos;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import com.webflux.WebfluxWithAzureCosmosDB.models.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private Country country;
}
