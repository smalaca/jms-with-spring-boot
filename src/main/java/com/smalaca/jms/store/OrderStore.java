package com.smalaca.jms.store;

import com.smalaca.jms.domain.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderStore implements Store<Order> {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void register(Order order) {
        this.orders.add(order);
    }

    @Override
    public Optional<Order> find(String orderNumber) {
        return orders.stream()
                .filter(order -> order.hasOrderNumberEquals(orderNumber))
                .findFirst();
    }
}
