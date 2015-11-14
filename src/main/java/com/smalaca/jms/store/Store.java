package com.smalaca.jms.store;

import com.smalaca.jms.domain.Order;

import java.io.Serializable;
import java.util.Optional;

public interface Store<T extends Serializable> {
    void register(T serializable);

    Optional<T> find(String id);
}
