package logic;

import java.io.Serializable;

public class Customer implements Serializable {

    private static int id_record;
    private int id;
    private String phone;
    private String email;
    private String address;
    private Payment paymentType;
    private Cart cart;

    public Customer(String phone, String email, String address, Payment paymentType, Cart cart) {
        this.id = id_record + 1;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.paymentType = paymentType;
        this.cart = cart;

    }

    public int getId() {
        return this.id;
    }


    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Payment getPaymentType() {
        return paymentType;
    }

    public String toString() {
        return cart.toString() + "\n**** Customer details ****" + "\nId: " + this.getId() + "\nPhone: " + phone + "\nEmail: " + email + "\nAddress: " + address
                + "\nPayment type: " + paymentType;
    }


}