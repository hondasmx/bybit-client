package com.bybit.subscription;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SubscriptionService {

    private List<Subscription> subscriptions;

    @EventListener(ApplicationReadyEvent.class)
    public void subscribeAll() {
        for (var subscription : subscriptions) {
            subscription.subscribe();
        }
    }
}
