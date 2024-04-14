package com.bybit.subscription;

import org.springframework.stereotype.Component;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.domain.websocket_message.public_channel.WebSocketTradeMessage;
import com.bybit.api.client.service.BybitApiClientFactory;
import com.bybit.configuration.SubscriptionConfiguration;
import com.bybit.processor.MessageProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import static com.bybit.utils.Constants.TRADES_PREFIX;

@Component
@Slf4j
@AllArgsConstructor
public class TradesSubscription implements Subscription {


    private final MessageProcessor<WebSocketTradeMessage> messageProcessor;
    private final SubscriptionConfiguration configuration;

    public void subscribe() {
        var client = BybitApiClientFactory
                .newInstance(BybitApiConfig.STREAM_TESTNET_DOMAIN, false)
                .newWebsocketClient();

        client.setMessageHandler(message -> {
            var data = (new ObjectMapper()).readValue(message, WebSocketTradeMessage.class);
            messageProcessor.process(data);
        });

        var subscriptionList = new ArrayList<String>();
        for (var ticker : configuration.getTrades()) {
            var topic = String.join(".", TRADES_PREFIX, ticker);
            subscriptionList.add(topic);
        }

        client.getPublicChannelStream(subscriptionList, BybitApiConfig.V5_PUBLIC_LINEAR);
    }
}
