package com.gargione.hexagonal.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import com.gargione.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.gargione.hexagonal.application.core.domain.Customer;


@Mapper(componentModel = ComponentModel.SPRING)
public interface CustomerEntityMapper {
    
    CustomerEntity toCustomerEntity(Customer customer);
    
    Customer toCustomer(CustomerEntity customerEntity);
    
}
