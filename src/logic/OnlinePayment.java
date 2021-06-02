package logic;

import java.io.Serializable;

public class OnlinePayment extends  Payment implements Serializable {

    public OnlinePayment() { }

    public String toString() {
        return "Online payment";
    }

}
