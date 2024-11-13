package com.gargione.hexagonal.adapters.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gargione.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.gargione.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.gargione.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.gargione.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.gargione.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gargione.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.gargione.hexagonal.application.ports.in.UpdateCustomerInputPort;

import jakarta.validation.Valid;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private InsertCustomerInputPort insertCustomerInputPort;
    
    private FindCustomerByIdInputPort findCustomerByIdInputPort;
    
    private UpdateCustomerInputPort updateCustomerInputPort;
    
    private DeleteCustomerInputPort deleteCustomerInputPort;
    
    private CustomerMapper customerMapper;
    
    public CustomerController(InsertCustomerInputPort insertCustomerInputPort, CustomerMapper customerMapper, FindCustomerByIdInputPort findCustomerByIdInputPort, UpdateCustomerInputPort updateCustomerInputPort, DeleteCustomerInputPort deleteCustomerInputPort) {
	super();
	this.insertCustomerInputPort = insertCustomerInputPort;
	this.findCustomerByIdInputPort = findCustomerByIdInputPort;
	this.customerMapper = customerMapper;
	this.updateCustomerInputPort = updateCustomerInputPort;
	this.deleteCustomerInputPort = deleteCustomerInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest){
	var customer = customerMapper.toCustomer(customerRequest);
	insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
	return ResponseEntity.ok().build();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable("id") final String id ){
	var customer = findCustomerByIdInputPort.find(id);
	var customerResponse = customerMapper.toCustomerReponse(customer);
	return ResponseEntity.ok(customerResponse);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable("id") final String id, @Valid @RequestBody CustomerRequest customerRequest ){
	var customer = customerMapper.toCustomer(customerRequest);
	customer.setId(id);
	updateCustomerInputPort.update(customer, customerRequest.getZipCode());
	var customerResponse = customerMapper.toCustomerReponse(customer);
	return ResponseEntity.ok(customerResponse);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final String id){
	deleteCustomerInputPort.delete(id);
	return ResponseEntity.noContent().build();
    }
    
    
}
