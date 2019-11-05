package com.demo.checkout.domain.service.impl;

import com.demo.checkout.domain.model.checkout.Address;
import com.demo.checkout.domain.service.AddressValidator;
import com.demo.checkout.domain.service.annotation.ServiceLocale;
import org.springframework.stereotype.Service;

@Service
@ServiceLocale(locale = "us")
public class UsAddressValidator implements AddressValidator {

    public void validate(Address address) {
      //validate address
      //Throw IllegalStateException
    }
}
