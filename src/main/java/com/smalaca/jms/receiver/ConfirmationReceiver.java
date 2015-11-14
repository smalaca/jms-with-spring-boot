package com.smalaca.jms.receiver;

import com.smalaca.jms.domain.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationReceiver {
    @JmsListener(destination = "confirmation.queue")
    public void receiveConfirmation(String orderNumber) {
        doSomethingAmazing();
    }

    private void doSomethingAmazing() {

    }
}
