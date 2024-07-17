package com.denisvlem.consumer.entity;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage {

  private UUID id;
  private String clientName;
  private List<GoodMessage> goods;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class GoodMessage {
    private String name;
    private Integer price;
  }
}
