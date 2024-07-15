package com.denisvlem.producer.controller;

import com.denisvlem.producer.client.OrderClient;
import com.denisvlem.producer.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer/api/v1/order")
@RequiredArgsConstructor
public class OrdersController {

  private final OrderClient orderClient;

  @PostMapping("")
  public void registerOrder(@RequestBody Order order) {
    orderClient.sendOrder(order);
  }

}
