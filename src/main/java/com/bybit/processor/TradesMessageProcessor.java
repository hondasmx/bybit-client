package com.bybit.processor;

import org.springframework.stereotype.Component;

import com.bybit.api.client.domain.websocket_message.public_channel.WebSocketTradeMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TradesMessageProcessor implements MessageProcessor<WebSocketTradeMessage> {

    @Override
    public void process(WebSocketTradeMessage message) {
        log.info(message.toString());
    }
}
