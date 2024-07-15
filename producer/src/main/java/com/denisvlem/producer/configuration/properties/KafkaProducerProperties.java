package com.denisvlem.producer.configuration.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "kafka.orders.producer")
public class KafkaProducerProperties {

  private String bootstrapServers;

  private String topic;

  private String clientId;

}
