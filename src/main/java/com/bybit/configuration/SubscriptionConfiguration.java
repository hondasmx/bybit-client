package com.bybit.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

import java.util.List;

@ConfigurationProperties(prefix = "subscriptions")
@Configuration
@Data
public class SubscriptionConfiguration {

    private List<String> trades;
    private List<OrderbookConfig> orderbook;

    @Data
    public static class OrderbookConfig {
        private String depth;
        private String symbol;
    }
}
