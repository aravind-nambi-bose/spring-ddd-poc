package com.demo.checkout.infrastructure.repository;

import com.demo.checkout.domain.model.checkout.Checkout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends CrudRepository<Checkout, String> {

}
