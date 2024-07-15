package com.denisvlem.producer.client;

import com.denisvlem.producer.configuration.properties.KafkaProducerProperties;
import com.denisvlem.producer.entity.Order;
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
   * @param order - order data
   */
  public void sendOrder(Order order) {

    var producerRecord = new ProducerRecord<String, Object>(
        kafkaProducerProperties.getTopic(),
        null,
        "key",
        order
    );
    log.info("Sending an order: {}, to the topic: {}", order, kafkaProducerProperties.getTopic());
    kafkaTemplate.send(producerRecord);
    log.info("Sending an order is done");
  }
}
