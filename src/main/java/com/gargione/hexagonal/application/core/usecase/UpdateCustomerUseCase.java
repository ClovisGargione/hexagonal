package com.gargione.hexagonal.application.core.usecase;

import com.gargione.hexagonal.application.core.domain.Customer;
import com.gargione.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gargione.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.gargione.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.gargione.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    
    private final UpdateCustomerOutputPort updateCustomerOutputPort;
    
    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
	super();
	this.findCustomerByIdInputPort = findCustomerByIdInputPort;
	this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
	this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
	findCustomerByIdInputPort.find(customer.getId());
	var address = findAddressByZipCodeOutputPort.find(zipCode);
	customer.setAddress(address);
	updateCustomerOutputPort.update(customer);
	
    }

}
