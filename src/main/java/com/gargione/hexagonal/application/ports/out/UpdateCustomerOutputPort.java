package com.gargione.hexagonal.application.ports.out;

import com.gargione.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
