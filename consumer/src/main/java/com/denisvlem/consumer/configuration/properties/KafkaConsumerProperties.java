package com.denisvlem.consumer.configuration.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "kafka.orders.consumer")
public class KafkaConsumerProperties {

  private String bootstrapServers;

  private String topic;

  private String groupId;
}
