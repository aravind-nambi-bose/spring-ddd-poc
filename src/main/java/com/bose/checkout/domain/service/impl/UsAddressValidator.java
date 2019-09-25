package com.bose.checkout.domain.service.impl;

import com.bose.checkout.domain.model.checkout.Address;
import com.bose.checkout.domain.service.AddressValidator;
import com.bose.checkout.domain.service.annotation.ServiceLocale;
import org.springframework.stereotype.Service;

@Service
@ServiceLocale(locale = "us")
public class UsAddressValidator implements AddressValidator {

    public void validate(Address address) {
      //validate address
      //Throw IllegalStateException
    }
}
