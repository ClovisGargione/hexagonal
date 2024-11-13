package com.gargione.hexagonal.application.ports.in;

import com.gargione.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
