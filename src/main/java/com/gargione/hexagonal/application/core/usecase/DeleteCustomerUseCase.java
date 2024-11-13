package com.gargione.hexagonal.application.core.usecase;

import com.gargione.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.gargione.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gargione.hexagonal.application.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort{

    private final DeleteCustomerOutputPort deleteCustomerOutputPort;
    
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    
    public DeleteCustomerUseCase(DeleteCustomerOutputPort deleteCustomerOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort) {
	super();
	this.deleteCustomerOutputPort = deleteCustomerOutputPort;
	this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    @Override
    public void delete(String id) {
	findCustomerByIdInputPort.find(id);
	deleteCustomerOutputPort.delete(id);
    }

}
