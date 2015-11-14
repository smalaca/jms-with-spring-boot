package com.smalaca.jms.service;

import com.smalaca.jms.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsClient {
    private static final String SIMPLE_QUEUE = "simple.queue";

    private final JmsTemplate jmsTemplate;

    @Autowired
    public JmsClient(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void addOrder(Order order) {
        jmsTemplate.convertAndSend(SIMPLE_QUEUE, order);
    }
}
