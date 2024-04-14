package com.bybit.processor;

import org.springframework.stereotype.Component;

import com.bybit.api.client.domain.websocket_message.public_channel.WebsocketOrderbookMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderbookMessageProcessor implements MessageProcessor<WebsocketOrderbookMessage> {
    @Override
    public void process(WebsocketOrderbookMessage message) {
        log.info(message.toString());
    }
}
