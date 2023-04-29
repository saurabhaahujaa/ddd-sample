package com.ddd_bootcamp.domain.events;


import java.util.List;

import com.ddd_bootcamp.domain.Item;

public class CartCheckedOutEvent implements  DomainEvent {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public CartCheckedOutEvent(List<Item> items) {
        this.items = items;
    }
}