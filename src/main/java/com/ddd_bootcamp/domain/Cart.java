package com.ddd_bootcamp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.ddd_bootcamp.domain.events.DomainEvent;

import com.ddd_bootcamp.domain.events.CartCheckedOutEvent;
import com.ddd_bootcamp.domain.events.ItemAddedToCartEvent;
import com.ddd_bootcamp.domain.events.ItemRemovedFromCartEvent;

public class Cart {
//    private List<Product> productitems = new ArrayList<>(); 
	private List<Item> items= new ArrayList();
	private UUID cartid;
	private Double cartPrice;
    private List<DomainEvent> events = new ArrayList<>();
    private boolean isCheckedOut;


	public Double getCartPrice() {
		return cartPrice;
	}
	
	public Double calculateCartTotalPrice(Cart cart) {
		for (Item item: cart.items) {
			this.cartPrice=this.cartPrice + item.calculatePrice(item);
		}
		return this.cartPrice;
		
	}

	public Cart() {
		// TODO Auto-generated constructor stub
		cartid=UUID.randomUUID();
		cartPrice=0.0;
	}

	public void add(Item item) {
//        products.add(product);
    	this.items.add(item);
    }

    public List<Item> getCartItems() {
        return this.items;
    }

	@Override
	public String toString() {
		return "Cart [items=" + items + ", cartid=" + cartid + "]";
	}
	public void remove(Product product) {
//        items.remove(applePencilProduct1);
        items.removeIf(item -> item.getProduct().equals(product));
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Cart cart = (Cart) o;
		return cartid.equals(cart.cartid);
	}

	@Override
	public int hashCode() {
		return cartid.hashCode();
	}
	
	public Order checkOut() {
	        List<Item> cartItems = items.stream().map(item ->
	                new Item(item.getProduct(),
	                        item.getProductPrice().getValue().doubleValue(),
	                        item.getQuantity())).collect(Collectors.toList());

	        apply(new CartCheckedOutEvent(cartItems));

	        List<Product> products = items.stream().flatMap(item ->
	                item.getFlattenedProducts().stream()).collect(Collectors.toList());
	        return new Order(products);
	}
	
	 private void apply(ItemAddedToCartEvent event) {
	        events.add(event);
	        this.items.add(new Item(new Product(event.getProductName(), event.getPrice()), event.getQuantity()));
	    }
	 private void apply(ItemRemovedFromCartEvent event) {
	        events.add(event);
	        this.items.
	                remove(this.items.stream().filter(item -> item.getProductName().equals(event.getProductName())).findFirst().get());
	    }

	    private void apply(CartCheckedOutEvent event) {
	        events.add(event);
	        this.isCheckedOut = true;
	    }



}