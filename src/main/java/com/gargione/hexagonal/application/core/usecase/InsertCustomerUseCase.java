package com.gargione.hexagonal.application.core.usecase;

import com.gargione.hexagonal.application.core.domain.Customer;
import com.gargione.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.gargione.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.gargione.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.gargione.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort{
    
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;
    
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;
    
    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
	super();
	this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
	this.insertCustomerOutputPort = insertCustomerOutputPort;
	this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
	var address = findAddressByZipCodeOutputPort.find(zipCode);
	customer.setAddress(address);
	insertCustomerOutputPort.insert(customer);
	sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
