package br.com.productseventsapi.ProductEventApi.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface UserEventProductProjection {
    Integer getId();
    String getUsername();
    String getProductName();
    BigDecimal getProductPrice();
    LocalDateTime getEventHour();
    String getEventLocation();
}
