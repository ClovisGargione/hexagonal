package com.gargione.hexagonal.adapters.out;

import org.springframework.stereotype.Component;

import com.gargione.hexagonal.adapters.out.repository.CustomerRepository;
import com.gargione.hexagonal.application.ports.out.DeleteCustomerOutputPort;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {

    private CustomerRepository customerRepository;

    public DeleteCustomerAdapter(CustomerRepository customerRepository) {
	super();
	this.customerRepository = customerRepository;
    }

    @Override
    public void delete(String id) {
	customerRepository.deleteById(id);
    }

}
