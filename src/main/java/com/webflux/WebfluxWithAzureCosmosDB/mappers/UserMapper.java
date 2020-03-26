package com.webflux.WebfluxWithAzureCosmosDB.mappers;

import com.webflux.WebfluxWithAzureCosmosDB.dtos.UserDto;
import com.webflux.WebfluxWithAzureCosmosDB.models.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper userMapper= Mappers.getMapper(UserMapper.class);
    UserDto toUserDto(User user);
    User toUserEntity(UserDto userDto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    User toUserForUpdate(UserDto userDto, @MappingTarget User user);
}
