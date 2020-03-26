package com.webflux.WebfluxWithAzureCosmosDB.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DistrictDto {
    Integer id;
    String districtCode;
    String districtName;
}
