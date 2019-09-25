package com.bose.checkout.domain.service;

import com.bose.checkout.domain.model.cart.Cart;
import com.bose.checkout.domain.model.checkout.Checkout;
import org.springframework.stereotype.Service;

@Service
public class HybrisCartService {

  public Cart findCartBy(String cartId) {
    return new Cart(cartId);
  }

  public void processOrder(Checkout checkout) {
    //Send the order to Hybris
  }

}
