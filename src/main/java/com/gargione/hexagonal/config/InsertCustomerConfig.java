package com.gargione.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gargione.hexagonal.adapters.FindAddressByZipCodeAdapter;
import com.gargione.hexagonal.adapters.out.InsertCustomerAdapter;
import com.gargione.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.gargione.hexagonal.application.core.usecase.InsertCustomerUseCase;

@Configuration
public class InsertCustomerConfig {

    @Bean
    InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, InsertCustomerAdapter insertCustomerAdapter, SendCpfValidationAdapter sendCpfValidationAdapter) {
	return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
