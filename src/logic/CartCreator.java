package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class CartCreator {

    private static Cart cart = new Cart();


    public static Cart getCart() {
        if (new File("src/ObjectFiles/cart.dat").isFile()) {
            try {
                FileInputStream fs = new FileInputStream("src/ObjectFiles/cart.dat");
                ObjectInputStream in = new ObjectInputStream(fs);
                cart = (Cart) in.readObject();
                in.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return cart;
    }

}
