package com.smalaca.jms.receiver;

import com.smalaca.jms.domain.Order;
import com.smalaca.jms.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {
    private final Store storeService;

    @Autowired
    public OrderReceiver(Store storeService) {
        this.storeService = storeService;
    }

    @JmsListener(destination = "simple.queue")
    @SendTo("confirmation.queue")
    public String receiveOrder(Order order) {
        storeService.register(order);
        return order.getOrderNumber();
    }
}
