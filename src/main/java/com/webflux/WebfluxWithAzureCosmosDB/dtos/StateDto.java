package com.webflux.WebfluxWithAzureCosmosDB.dtos;

import com.webflux.WebfluxWithAzureCosmosDB.models.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StateDto {
    Integer id;
    String stateCode;
    String stateName;
    District district;
}
