package com.demo.checkout.config;

import com.demo.checkout.domain.service.AddressValidator;
import com.demo.checkout.domain.service.annotation.ServiceLocale;
import java.util.HashMap;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public HashMap<String, AddressValidator> addressValidatorMap(
      List<? extends AddressValidator> addressValidators) {
    HashMap<String, AddressValidator> addressValidatorMap = new HashMap<>();
    addressValidators.forEach(t -> {
      ServiceLocale serviceLocale = t.getClass().getAnnotation(ServiceLocale.class);
      addressValidatorMap.put(serviceLocale.locale(), t);
    });
    return addressValidatorMap;
  }
}
