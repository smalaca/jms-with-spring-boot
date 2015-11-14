package com.smalaca.jms.receiver;

import com.smalaca.jms.JmsApplication;
import com.smalaca.jms.domain.Order;
import com.smalaca.jms.service.JmsClient;
import com.smalaca.jms.store.Store;
import junit.framework.Assert.*;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JmsApplication.class)
public class OrderReceiverTest {
    private static final String SOME_ORDER_NUMBER = "order1";

    @Autowired private JmsClient clientService;
    @Autowired private Store store;

    @Test
    public void sendSimpleMessage() {
        clientService.addOrder(new Order(SOME_ORDER_NUMBER));

        Optional<Order> storedOrder = store.find(SOME_ORDER_NUMBER);
        assertThat(storedOrder.isPresent()).isTrue();
        assertThat(storedOrder.get().getOrderNumber()).isEqualTo(SOME_ORDER_NUMBER);
    }
}