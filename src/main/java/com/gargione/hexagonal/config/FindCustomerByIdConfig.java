package com.gargione.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gargione.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.gargione.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findAddressByZipCodeAdapter) {
	return new FindCustomerByIdUseCase(findAddressByZipCodeAdapter);
    }
}
