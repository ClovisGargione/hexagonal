package com.gargione.hexagonal.application.core.usecase;

import com.gargione.hexagonal.application.core.domain.Customer;
import com.gargione.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gargione.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort{

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
    
    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
	super();
	this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
	return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
