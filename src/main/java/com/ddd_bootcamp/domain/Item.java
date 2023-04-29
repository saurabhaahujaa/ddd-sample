package com.ddd_bootcamp.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Item {
	private Product product;
	private Double cartprice;
	private Integer qty;
	
	public Double getTotalprice() {
		return cartprice;
	}
	public Double calculatePrice(Item item) {
		this.cartprice = item.qty.doubleValue()*item.product.getPrice().getValue().doubleValue();
		return cartprice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return qty;
	}
	public Item() {
		super();
	}
	public Item(Product product, Integer i) {
		super();
		this.product = product;
		this.qty = i;
	}
	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + qty + "]";
	}
	public Item(Integer qty) {
		super();
		this.qty = qty;
	}
	public String getProductName() {
        return product.getName();
    }
	
	public Price getProductPrice() {
	        return product.getPrice();
	 }
	public Item(Product product, Double cartprice, Integer qty) {
		super();
		this.product = product;
		this.cartprice = cartprice;
		this.qty = qty;
	}
    public List<Product> getFlattenedProducts() {
        return IntStream.range(0, qty).mapToObj(value ->
                new Product(getProductName(), getProductPrice())).collect(Collectors.toList());
    }
}
