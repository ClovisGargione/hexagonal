package com.gargione.hexagonal.adapters.in.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.gargione.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.gargione.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.gargione.hexagonal.application.ports.in.UpdateCustomerInputPort;

@Component
public class ReceiveValidatedCpfConsumer {
    
    private UpdateCustomerInputPort updateCustomerInputPort;
    
    private CustomerMessageMapper customerMessageMapper;
    
    public ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort, CustomerMessageMapper customerMessageMapper) {
	super();
	this.updateCustomerInputPort = updateCustomerInputPort;
	this.customerMessageMapper = customerMessageMapper;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "gargione")
    public void receive(CustomerMessage customerMessage) {
	var customer = customerMessageMapper.toCustomer(customerMessage);
	updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
