package com.denisvlem.consumer.configuration;

import com.denisvlem.consumer.entity.Order;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(KafkaConsumerProperties.class)
public class KafkaConsumerConfiguration {


  private final KafkaConsumerProperties kafkaConsumerProperties;

  @Bean
  public ConsumerFactory<String, Order> consumerFactory() {
    log.debug("Properties: {}", kafkaConsumerProperties);
    Map<String, Object> configs = Map.of(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerProperties.getBootstrapServers(),
        ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerProperties.getGroupId(),
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class
    );

    return new DefaultKafkaConsumerFactory<>(
        configs,
        new StringDeserializer(),
        new JsonDeserializer<>(Order.class, false)
    );
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Order> listenerContainerFactory(
      ConsumerFactory<String, Order> consumerFactory
  ) {
    var factory = new ConcurrentKafkaListenerContainerFactory<String, Order>();
    factory.setConsumerFactory(consumerFactory);
    return factory;
  }
}
