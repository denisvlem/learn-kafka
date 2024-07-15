package com.denisvlem.consumer.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  private String clientName;
  private List<Good> goods;

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Good {
    private String name;
    private Integer price;
  }
}
