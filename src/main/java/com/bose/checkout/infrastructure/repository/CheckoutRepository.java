package com.bose.checkout.infrastructure.repository;

import com.bose.checkout.domain.model.checkout.Checkout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends CrudRepository<Checkout, String> {

}
