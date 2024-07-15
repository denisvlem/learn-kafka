package com.denisvlem.producer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ProducerApplicationTest extends AbstractIntegrationTest{

  @Autowired
  private ProducerApplication producerApplication;
  @Test
  void testApplication() {
    assertThat(producerApplication).isNotNull();
  }

}
