package com.demo.checkout.domain.model.checkout;

import com.demo.checkout.domain.service.AddressValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

  private String email;
  private Address address;

  @JsonIgnore
  private AddressValidator addressValidator;


  private void setAddressValidator(AddressValidator addressValidator) {
    this.addressValidator = addressValidator;
  }

  private void setEmail(String email) {
    //email validation
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

  private void setAddress(Address address) {
    //validate address
    this.address = address;
  }

  public Address getAddress() {
    return this.address;
  }

  public static class Builder {

    private String email;
    private Address address;
    private AddressValidator addressValidator;

    public Builder withAddressValidator(AddressValidator addressValidator) {
      this.addressValidator = addressValidator;
      return this;
    }

    public Builder withEmailAndAddress(String email, Address address) {
      this.email = email;
      this.address = address;
      return this;
    }

    public User build() {
      User user = new User();
      user.setAddressValidator(addressValidator);
      user.setEmail(email);
      user.setAddress(address);
      return user;
    }

  }

}
