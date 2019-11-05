package com.demo.checkout.domain.service;

import com.demo.checkout.domain.model.cart.Cart;
import com.demo.checkout.domain.model.checkout.Checkout;
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
