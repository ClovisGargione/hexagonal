package com.gargione.hexagonal.adapters.out.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import com.gargione.hexagonal.adapters.out.client.response.AddressResponse;
import com.gargione.hexagonal.application.core.domain.Address;

@Mapper(componentModel = ComponentModel.SPRING)
public interface AddressResponseMapper {
    
    Address toAddress(AddressResponse addressResponse);
}
