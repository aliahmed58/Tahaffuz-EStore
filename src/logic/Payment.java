package logic;

import java.io.Serializable;

public abstract class Payment implements Serializable {

    private double price;

    public double getPrice() {
        return price;
    }

    public  void setPrice(double price) {
        this.price = price;
    }


}
