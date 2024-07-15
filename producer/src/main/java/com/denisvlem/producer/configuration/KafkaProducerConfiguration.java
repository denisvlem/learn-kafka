package com.denisvlem.producer.configuration;

import com.denisvlem.producer.configuration.properties.KafkaProducerProperties;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Log4j2
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(KafkaProducerProperties.class)
public class KafkaProducerConfiguration {

  private final KafkaProducerProperties kafkaProducerProperties;

  @Bean
  public ProducerFactory<String, Object> producerFactory() {
    log.info("Properties: {}", kafkaProducerProperties);
    Map<String, Object> configProps = Map.of(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProducerProperties.getBootstrapServers(),
        ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, false,
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
    );

    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate<String, Object> kafkaTemplate(
      ProducerFactory<String, Object> producerFactory) {

    return new KafkaTemplate<>(producerFactory);
  }
}
