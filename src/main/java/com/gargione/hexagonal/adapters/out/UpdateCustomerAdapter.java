package com.gargione.hexagonal.adapters.out;

import org.springframework.stereotype.Component;

import com.gargione.hexagonal.adapters.out.repository.CustomerRepository;
import com.gargione.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.gargione.hexagonal.application.core.domain.Customer;
import com.gargione.hexagonal.application.ports.out.UpdateCustomerOutputPort;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort{

    private CustomerRepository customerRepository;
    
    private CustomerEntityMapper customerEntityMapper;
    
    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
	super();
	this.customerRepository = customerRepository;
	this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
	var customerEntity = customerEntityMapper.toCustomerEntity(customer);
	customerRepository.save(customerEntity);
    }

}
