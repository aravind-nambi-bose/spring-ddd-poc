package com.bose.checkout.application.service;

import com.bose.checkout.domain.model.cart.Cart;
import com.bose.checkout.domain.model.checkout.Address;
import com.bose.checkout.domain.model.checkout.Checkout;
import com.bose.checkout.domain.service.AddressValidator;
import com.bose.checkout.domain.service.HybrisCartService;
import com.bose.checkout.infrastructure.repository.CheckoutRepository;
import java.util.HashMap;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

  private final HybrisCartService hybrisCartService;
  private final CheckoutRepository checkoutRepository;
  private final HashMap<String, AddressValidator> addressValidatorMap;

  @Inject
  public CheckoutService(HybrisCartService hybrisCartService,
      CheckoutRepository checkoutRepository,
      HashMap<String, AddressValidator> addressValidatorMap) {
    this.hybrisCartService = hybrisCartService;
    this.checkoutRepository = checkoutRepository;
    this.addressValidatorMap = addressValidatorMap;
  }


  public Checkout initiateCheckout(String cartId) {
    Cart cart = this.hybrisCartService.findCartBy(cartId);
    Checkout checkout = new Checkout(cart);
    return this.checkoutRepository.save(checkout);
  }

  public Checkout addUserInfo(String checkoutId, String email, Address address) {
    Checkout checkout = findCheckoutById(checkoutId);
    //TODO: Figure out a better way to initialize Checkout with required Domain services

    //FIXME: Is there a better way to pass the domain service when adding node to the Aggregate
    checkout.createUser(email, address, addressValidatorMap);
    return this.checkoutRepository.save(checkout);
  }

  public void processOrder(String checkoutId) {
    Checkout checkout = findCheckoutById(checkoutId);
    if (checkout.canBeProccessed()) {
      this.hybrisCartService.processOrder(checkout);
    }

  }

  private Checkout findCheckoutById(String checkoutId) {
    return this.checkoutRepository.findById(checkoutId)
        .orElseThrow(() -> new IllegalStateException("Invalid checkout id"));
  }

}
