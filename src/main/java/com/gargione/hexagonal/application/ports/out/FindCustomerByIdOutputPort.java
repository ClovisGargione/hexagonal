package com.gargione.hexagonal.application.ports.out;

import java.util.Optional;

import com.gargione.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
