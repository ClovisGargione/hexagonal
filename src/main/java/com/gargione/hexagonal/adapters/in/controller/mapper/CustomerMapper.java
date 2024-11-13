package com.gargione.hexagonal.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import com.gargione.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.gargione.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.gargione.hexagonal.application.core.domain.Customer;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(target="id", ignore = true)
    @Mapping(target="address", ignore = true)
    @Mapping(target="isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
    
    CustomerResponse toCustomerReponse(Customer costumer);
    
}
