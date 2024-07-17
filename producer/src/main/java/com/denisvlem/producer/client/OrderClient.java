package com.denisvlem.producer.client;

import com.denisvlem.producer.configuration.properties.KafkaProducerProperties;
import com.denisvlem.producer.entity.OrderMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderClient {

  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final KafkaProducerProperties kafkaProducerProperties;

  /**
   * Send the order to Kafka broker.
   *
   * @param orderMessage - order data
   */
  public void sendOrder(OrderMessage orderMessage) {

    var producerRecord = new ProducerRecord<String, Object>(
        kafkaProducerProperties.getTopic(),
        null,
        "key",
        orderMessage
    );
    log.info("Sending an order: {}, to the topic: {}", orderMessage, kafkaProducerProperties.getTopic());
    kafkaTemplate.send(producerRecord);
    log.info("Sending an order is done");
  }
}
