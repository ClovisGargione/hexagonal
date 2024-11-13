package com.gargione.hexagonal.adapters.out;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.gargione.hexagonal.adapters.out.repository.CustomerRepository;
import com.gargione.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.gargione.hexagonal.application.core.domain.Customer;
import com.gargione.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort{

    private CustomerRepository customerRepository;
    
    private CustomerEntityMapper customerEntityMapper;
    
    public FindCustomerByIdAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
	super();
	this.customerRepository = customerRepository;
	this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String id) {
	var customerEntity = customerRepository.findById(id);
	return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }

}
