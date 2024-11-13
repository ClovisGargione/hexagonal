package com.gargione.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gargione.hexagonal.adapters.FindAddressByZipCodeAdapter;
import com.gargione.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.gargione.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.gargione.hexagonal.application.core.usecase.UpdateCustomerUseCase;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, UpdateCustomerAdapter updateCustomerAdapter) {
	return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
