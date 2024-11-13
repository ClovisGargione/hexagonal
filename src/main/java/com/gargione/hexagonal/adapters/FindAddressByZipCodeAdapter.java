package com.gargione.hexagonal.adapters;

import org.springframework.stereotype.Component;

import com.gargione.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.gargione.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.gargione.hexagonal.application.core.domain.Address;
import com.gargione.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    
    private AddressResponseMapper addressResponseMapper;
    
    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient, AddressResponseMapper addressResponseMapper) {
	super();
	this.findAddressByZipCodeClient = findAddressByZipCodeClient;
	this.addressResponseMapper = addressResponseMapper;
    }



    @Override
    public Address find(String zipCode) {
	var response = findAddressByZipCodeClient.find(zipCode);
	return addressResponseMapper.toAddress(response);
    }

}
