package com.gargione.hexagonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gargione.hexagonal.adapters.out.DeleteCustomerAdapter;
import com.gargione.hexagonal.application.core.usecase.DeleteCustomerUseCase;
import com.gargione.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    DeleteCustomerUseCase deleteCustomerUseCase(DeleteCustomerAdapter deleteCustomerAdapter, FindCustomerByIdUseCase findCustomerByIdUseCase) {
	return new DeleteCustomerUseCase(deleteCustomerAdapter, findCustomerByIdUseCase);
    }
}
