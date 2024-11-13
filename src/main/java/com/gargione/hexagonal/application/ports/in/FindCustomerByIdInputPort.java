package com.gargione.hexagonal.application.ports.in;

import com.gargione.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
