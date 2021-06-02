/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Cart implements Serializable {
    private  Map<Product, Integer> productsInCart = new HashMap<Product, Integer>();
    private double total;
    private int NoOfItems;
    
    public Cart() {

    }
    
    public void addToCart(Product x) {

        if (productsInCart.containsKey(x)) {
            productsInCart.put(x, productsInCart.get(x) + 1);
        }
        else {
            productsInCart.put(x, 1);
        }
        this.NoOfItems++;
    }
    
    public void removeFromCart(Product x) {
        productsInCart.remove(x);
        this.total -= x.getPrice();
        this.NoOfItems --;
    }
    
    public void calcTotal() {
       
        for (Product x : productsInCart.keySet()) {
            this.total += x.getPrice() * productsInCart.get(x);
        }
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal() {
        this.total = 0;
    }
    
    public int getNoOfItems() {
        return this.NoOfItems;
    }

    public void decreaseQuantity(Product x) {
        if (productsInCart.get(x) > 1) {
            productsInCart.put(x, productsInCart.get(x) - 1);
        }
        else {
            this.removeFromCart(x);
        }
    }

    public void increaseQty (Product x) {
        productsInCart.put(x, productsInCart.get(x) + 1);
    }
    
    public Map<Product, Integer> getProducts() {
        return productsInCart;
    }

    @Override
    public String toString() {
        return "items: " + productsInCart + "\nItem count: " + getNoOfItems() + "\nTotal price: " + total;
    }
}
