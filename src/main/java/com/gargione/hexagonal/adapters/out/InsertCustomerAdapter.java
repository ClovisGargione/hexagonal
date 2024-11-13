package com.gargione.hexagonal.adapters.out;

import org.springframework.stereotype.Component;

import com.gargione.hexagonal.adapters.out.repository.CustomerRepository;
import com.gargione.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.gargione.hexagonal.application.core.domain.Customer;
import com.gargione.hexagonal.application.ports.out.InsertCustomerOutputPort;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort{

    private CustomerRepository customerRepository;
    
    private CustomerEntityMapper customerEntityMapper;
    
    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
	super();
	this.customerRepository = customerRepository;
	this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
	var customerEntity = customerEntityMapper.toCustomerEntity(customer);
	customerRepository.save(customerEntity);
    }

}
