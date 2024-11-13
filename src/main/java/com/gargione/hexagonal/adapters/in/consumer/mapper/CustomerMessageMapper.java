package com.gargione.hexagonal.adapters.in.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.gargione.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.gargione.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMesssage);
}
