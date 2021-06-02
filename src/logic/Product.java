/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable{
    
    private String name;
    private String type;
    private double price;
    private String link;
    private String description;
    
    public Product(String name, String type, String description, double price, String link) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.price + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Product)) return false;
        Product product = (Product) obj;
        return product.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

}
