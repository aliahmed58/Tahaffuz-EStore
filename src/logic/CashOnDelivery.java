package logic;

import java.io.Serializable;

public class CashOnDelivery extends Payment implements Serializable {

    private final double CODCharges = 50;

    public CashOnDelivery() {
        super.setPrice(this.getPrice() + 50);
    }

    public String toString() {
        return "Cash on delivery";
    }

}
