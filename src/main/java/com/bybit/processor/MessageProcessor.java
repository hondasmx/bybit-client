package com.bybit.processor;

public interface MessageProcessor<T> {

    void process(T message);
}
