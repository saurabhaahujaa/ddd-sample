package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Cart cart1 = new Cart();
        Cart cart2= new Cart();
        
        Product applepencil = new Product("Apple Pencil",
        		new Price(BigDecimal.valueOf(10), Currency.getInstance("USD")));
        Item pencilitem=new Item(applepencil,2);
        cart1.add(pencilitem);
        
        Product headphone= new Product("Sony Headphone",new Price(BigDecimal.valueOf(20), Currency.getInstance("USD")));

        Item headphoneitem= new Item(headphone,1);
        cart1.add(headphoneitem);
        
        cart1.remove(applepencil);

        System.out.println("Cart = " + cart1);
//        List<Product> products = cart1.getProducts();
        List<Item> items = cart1.getCartItems();
        System.out.println("---------------------------------------");
        System.out.println("items = " + items);
        System.out.println("----------------------------------------");
        
;
        cart2.add(pencilitem);
        cart2.add(headphoneitem);
        
        System.out.println("Cart = " + cart2);
//      List<Product> products = cart1.getProducts();
      List<Item> items2 = cart2.getCartItems();
      System.out.println("---------------------------------------");
      System.out.println("items = " + items2);
      System.out.println("----------------------------------------");

        System.out.println("----------------------------------------");
        System.out.print("cart1.equals(cart2) :");
        System.out.println(cart1.equals(cart2)? "true=Carts are same " : "false=Carts are different");
        System.out.println("Total Cart price for "+cart1);
        System.out.println(cart1.calculateCartTotalPrice(cart1));
        System.out.println("-------------------------------------------------------------------");

        Price applePencilPrice = CompetitorBasedPricer.getPrice("Apple Pencil");

        System.out.println("Discounted Price for Apple Pencil: " + applePencilPrice);

        Price sonyWirelessHeadphonePrice = CompetitorBasedPricer.getPrice("Sony Headphone");

        System.out.println("Discounted Price for Sony Headphone: "
                + sonyWirelessHeadphonePrice);

        System.out.println("-------------------------------------------------------------------");

        Cart cart = new Cart();

        cart.add(new Item( new Product("Apple Pencil",applePencilPrice), 1));
        cart.add(new Item( new Product("Sony Wireless headphone",sonyWirelessHeadphonePrice), 1));

        System.out.println("cart = " + cart);
        
        System.out.println("Cart = " + cart);

        System.out.println("-------------------------------------------------------------------");

        System.out.println("Cart checked out = " + cart.checkOut());
        //System.out.println("Cart checked out = " + CheckOutService.checkOut(cart));

        System.out.println("-------------------------------------------------------------------");
        Address address = new Address("Pune");
        Customer customer = new Customer(address);

        Account account = new Account();
        customer.addAccount(account);

        System.out.println("---------------------------------------------------------");
        System.out.println("Before Address Change = " + customer);
        System.out.println("---------------------------------------------------------");

        Address newAddress = new Address("Mumbai");
        //start database transaction
        customer.updateAddress(newAddress);
        //end database transaction

        System.out.println("---------------------------------------------------------");
        System.out.println("After Address Change = " + customer);
        System.out.println("---------------------------------------------------------");
    }
}
