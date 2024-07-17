package com.denisvlem.consumer.listener;

import com.denisvlem.consumer.entity.OrderMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdersListener {

  private final ObjectMapper objectMapper;

  @KafkaListener(
      topics = "${kafka.orders.consumer.topic}",
      groupId = "${kafka.orders.consumer.group-id}",
      containerFactory = "listenerContainerFactory"
  )
  public void listenOrders(ConsumerRecord<String, OrderMessage> consumerRecord) {

    var order = consumerRecord.value();
    log.info("Message consumed key: {}, value: {}", consumerRecord.key(),
        objectMapper.valueToTree(order).toPrettyString()
    );
  }

}
