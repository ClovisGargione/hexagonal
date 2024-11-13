package com.gargione.hexagonal.application.ports.in;

import com.gargione.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
