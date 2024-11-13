package com.gargione.hexagonal.application.ports.out;

import com.gargione.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
