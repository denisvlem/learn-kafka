package com.denisvlem.consumer.listener;

import com.denisvlem.consumer.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdersListener {

  @KafkaListener(
      topics = "${kafka.orders.consumer.topic}",
      groupId = "${kafka.orders.consumer.group-id}",
      containerFactory = "listenerContainerFactory"
  )
  public void listenOrders(ConsumerRecord<String, Order> consumerRecord) {
    log.info("Message consumed key: {}, value: {}", consumerRecord.key(), consumerRecord.value());
  }

}
