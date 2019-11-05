package com.demo.checkout.application.web.controller;

import com.demo.checkout.application.service.CheckoutService;
import com.demo.checkout.domain.model.checkout.Checkout;
import com.demo.checkout.domain.model.checkout.User;
import com.demo.checkout.application.web.dto.CheckoutCart;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

  private final CheckoutService checkoutService;

  @Inject
  public CheckoutController(CheckoutService checkoutService) {
    this.checkoutService = checkoutService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Checkout initiateCheckout(@RequestBody CheckoutCart checkoutCart) {
    return this.checkoutService.initiateCheckout(checkoutCart.getCartId());
  }

  @PutMapping(path = "/{checkoutId}/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Checkout addUserInfo(@PathVariable String checkoutId, @RequestBody User user) {
    return this.checkoutService.addUserInfo(checkoutId, user.getEmail(), user.getAddress());
  }

  @PostMapping(path = "/{checkoutId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void processCheckout(@PathVariable String checkoutId,
      @Pattern(regexp = "^(submit)$", flags = Flag.CASE_INSENSITIVE, message = "Action not supported")
      @RequestParam(name = "action") String action) {
    this.checkoutService.processOrder(checkoutId);
  }

}
