package logic;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadCustomer {
    public static void main(String[] args) {
        try {
            FileInputStream fs = new FileInputStream("src/ObjectFiles/customer.dat");
            ObjectInputStream in = new ObjectInputStream(fs);
            System.out.println(in.readObject());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}