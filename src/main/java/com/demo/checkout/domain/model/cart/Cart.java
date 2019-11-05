package com.demo.checkout.domain.model.cart;

//FIXME: Should this be in its own library to be consumed by Checkout and Cart service
public class Cart {

  private String id;
  private String locale;

  public Cart(String id) {
    this.id = id;
  }

  public String getLocale() {
    return locale;
  }

}
