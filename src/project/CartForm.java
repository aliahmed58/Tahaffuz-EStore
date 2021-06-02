/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import logic.CartCreator;
import logic.Product;
import logic.Cart;

public class CartForm extends javax.swing.JFrame {

    // custom variables
    private Cart cart;
    private double totalPrice;
    private ArrayList<JPanel> panels = new ArrayList<JPanel>();
    private ArrayList<JButton> delIcons = new ArrayList<JButton>();
    private ArrayList<JButton> decreaseIcons = new ArrayList<JButton>();
    private ArrayList<JLabel> nameLabels = new ArrayList<JLabel>();
    private ArrayList<JButton> plusIcons = new ArrayList<JButton>();

    public CartForm() {

        this.cart = CartCreator.getCart();
        initComponents();

    }

    private void initComponents() {

        navbarPanel = new javax.swing.JPanel();
        navbar = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        panelForScroll = new javax.swing.JPanel();
        checkoutBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        updateCart = new javax.swing.JButton();
        headings = new javax.swing.JPanel();
        nameHeading = new javax.swing.JLabel();
        qtyHeading = new javax.swing.JLabel();
        PriceHeading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(970, 700));
        setResizable(false);


        UIManager.put("Button.disabledText", new ColorUIResource(new Color(220, 220, 220)));

        navbarPanel.setBackground(new java.awt.Color(57, 189, 200));
        navbarPanel.setLayout(new java.awt.BorderLayout());

        navbar.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        navbar.setForeground(new java.awt.Color(254, 254, 254));
        navbar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        navbar.setText("Tahaffuz   |   My Cart");
        navbarPanel.add(navbar, java.awt.BorderLayout.CENTER);

        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelForScroll.setLayout(new javax.swing.BoxLayout(panelForScroll, javax.swing.BoxLayout.PAGE_AXIS));


        if (this.cart == null || this.cart.getProducts().size() == 0) {

            JPanel panel = new JPanel();
            panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(200, 1, 1, 1));

            JLabel noItems = new JLabel("The cart is currently Empty");
            noItems.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            noItems.setFont(new java.awt.Font("Ubuntu", 1, 20));
            noItems.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 30));
            panel.add(noItems);

            JButton goShopping = new JButton("Shop Now");
            goShopping.setBackground(new java.awt.Color(57, 189, 200));
            goShopping.setForeground(new java.awt.Color(254, 254, 254));
            goShopping.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
            goShopping.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));
            goShopping.setBorderPainted(false);
            goShopping.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            goShopping.setFocusPainted(false);
            goShopping.setRequestFocusEnabled(false);
            goShopping.setVerifyInputWhenFocusTarget(false);
            goShopping.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    dispose();
                    new Store().setVisible(true);
                }
            });

            panel.add(goShopping);

            panelForScroll.add(panel);
        }

        if (this.cart != null) {
            for (Product x : this.cart.getProducts().keySet()) {


                JPanel singleItem = new JPanel();
                singleItem.setBackground(new java.awt.Color(57, 189, 200));
                singleItem.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 20, 1));
                singleItem.setMinimumSize(new java.awt.Dimension(182, 66));
                singleItem.setMaximumSize(new java.awt.Dimension(900, 66));
                singleItem.setPreferredSize(new java.awt.Dimension(900, 66));
                singleItem.setName(x.getName());

                singleItem.setLayout(new java.awt.GridLayout());

                JLabel name = new JLabel();
                name.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
                name.setForeground(new java.awt.Color(254, 254, 254));
                name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                name.setText(x.getName());
                name.setName(x.getName());
                nameLabels.add(name);
                singleItem.add(name);

                JLabel q = new JLabel();
                q.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
                q.setForeground(new java.awt.Color(254, 254, 254));
                q.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                q.setText("x" + cart.getProducts().get(x));
                singleItem.add(q);

                JLabel price = new JLabel();
                price.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
                price.setForeground(new java.awt.Color(254, 254, 254));
                price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                price.setText(x.getPrice() + " PKR");
                price.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
                singleItem.add(price);

                JPanel removePanel = new JPanel();
                removePanel.setBackground(new java.awt.Color(57, 189, 200));
                removePanel.setLayout(new java.awt.GridLayout());

                JButton decreaseQty = new JButton();
                decreaseQty.setBackground(new java.awt.Color(57, 189, 200));
                decreaseQty.setForeground(new java.awt.Color(57, 189, 200));
                decreaseQty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
                decreaseQty.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                decreaseQty.setBorderPainted(false);
                decreaseQty.setContentAreaFilled(false);
                decreaseQty.setFocusable(false);
                decreaseQty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                removePanel.add(decreaseQty);

                JButton increaseQty = new JButton();
                increaseQty.setBackground(new java.awt.Color(57, 189, 200));
                increaseQty.setForeground(new java.awt.Color(57, 189, 200));
                increaseQty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
                increaseQty.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                increaseQty.setBorderPainted(false);
                increaseQty.setContentAreaFilled(false);
                increaseQty.setFocusable(false);
                increaseQty.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                removePanel.add(increaseQty);

                JButton removeFromCart = new JButton();
                removeFromCart.setBackground(new java.awt.Color(57, 189, 200));
                removeFromCart.setForeground(new java.awt.Color(57, 189, 200));
                removeFromCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.png"))); // NOI18N
                removeFromCart.setBorderPainted(false);
                removeFromCart.setContentAreaFilled(false);
                removeFromCart.setFocusPainted(false);
                removeFromCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                removeFromCart.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {

                    }
                });
                removePanel.add(removeFromCart);

                singleItem.add(removePanel);
                this.delIcons.add(removeFromCart);
                this.decreaseIcons.add(decreaseQty);
                this.plusIcons.add(increaseQty);
                this.panelForScroll.add(singleItem);
                this.panels.add(singleItem);
            }
        }

        if (CartCreator.getCart() != null) {
            this.cart.setTotal();
            this.cart.calcTotal();
            this.totalPrice = this.cart.getTotal();
        }


        for (int i = 0; i < this.delIcons.size(); i++) {

            String name = panelForScroll.getComponent(i).getName();
            int finalI = i;

            this.delIcons.get(i).addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Product x = removeFromCartList(name);
                    cart.removeFromCart(x);
                    cart.setTotal();
                    cart.calcTotal();
                    panels.get(finalI).setEnabled(false);
                    updateCart.setEnabled(true);
                    delIcons.get(finalI).setEnabled(false);
                    plusIcons.get(finalI).setEnabled(false);
                    decreaseIcons.get(finalI).setEnabled(false);
                }

            });
        }

        for (int i = 0; i < this.plusIcons.size(); i++) {
            String name = panelForScroll.getComponent(i).getName();
            int finalI = i;
            Product x = removeFromCartList(name);

            this.plusIcons.get(i).addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    JLabel qty = (JLabel) panels.get(finalI).getComponent(1);

                    cart.increaseQty(x);
                    decreaseIcons.get(finalI).setEnabled(true);

                    Integer newQty = cart.getProducts().get(x);
                    qty.setText("x" + newQty);
                    cart.setTotal();
                    cart.calcTotal();

                    String priceResult = String.format("%.2f", cart.getTotal());
                    total.setText("Total Cost: " + priceResult + " PKR");

                    saveToFile();

                }
            });
        }

        for (int i = 0; i < this.decreaseIcons.size(); i++) {
            String name = panelForScroll.getComponent(i).getName();
            int finalI = i;
            Product x = removeFromCartList(name);
            if (cart.getProducts().get(x) == 1) {
                this.decreaseIcons.get(i).setEnabled(false);
            }

            this.decreaseIcons.get(i).addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                    JLabel qty = (JLabel) panels.get(finalI).getComponent(1);

                    cart.decreaseQuantity(x);
                    Integer newQty = cart.getProducts().get(x);
                    qty.setText("x" + newQty);
                    cart.setTotal();
                    cart.calcTotal();

                    String priceResult = String.format("%.2f", cart.getTotal());
                    total.setText("Total Cost: " + priceResult + " PKR");

                    saveToFile();

                    if (cart.getProducts().get(x) <= 1)
                        decreaseIcons.get(finalI).setEnabled(false);
                }

            });
        }


        ScrollPane.setViewportView(panelForScroll);
        ScrollPane.getVerticalScrollBar().setUnitIncrement(12);

        checkoutBtn.setBackground(new java.awt.Color(57, 189, 200));
        checkoutBtn.setForeground(new java.awt.Color(254, 254, 254));
        checkoutBtn.setText("Checkout");
        checkoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkoutBtn.setBorderPainted(false);
        checkoutBtn.setFocusPainted(false);
        checkoutBtn.setRequestFocusEnabled(false);
        checkoutBtn.setVerifyInputWhenFocusTarget(false);
        checkoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnActionPerformed(evt);
            }
        });


        updateCart.setBackground(new java.awt.Color(57, 189, 200));
        updateCart.setForeground(new java.awt.Color(254, 254, 254));
        updateCart.setText("Update Cart");
        updateCart.setEnabled(false);
        updateCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateCart.setBorderPainted(false);
        updateCart.setFocusPainted(false);
        updateCart.setRequestFocusEnabled(false);
        updateCart.setVerifyInputWhenFocusTarget(false);
        updateCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToFile();
                onUpdateCart(evt);
            }
        });


        String priceResult = String.format("%.2f", this.totalPrice);
        total.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total.setText("Total Cost: " + priceResult + " PKR");

        homeBtn.setBackground(new java.awt.Color(57, 189, 200));
        homeBtn.setForeground(new java.awt.Color(254, 254, 254));
        homeBtn.setText("Home");
        homeBtn.setBorderPainted(false);
        homeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        homeBtn.setFocusPainted(false);
        homeBtn.setRequestFocusEnabled(false);
        homeBtn.setVerifyInputWhenFocusTarget(false);
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        nameHeading.setText("Product name");
        nameHeading.setFont(new java.awt.Font("Ubuntu", 1, 17));

        qtyHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        qtyHeading.setFont(new java.awt.Font("Ubuntu", 1, 17));
        qtyHeading.setText("Price");

        PriceHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PriceHeading.setFont(new java.awt.Font("Ubuntu", 1, 17));
        PriceHeading.setText("Quantity");


        javax.swing.GroupLayout headingsLayout = new javax.swing.GroupLayout(headings);
        headings.setLayout(headingsLayout);
        headingsLayout.setHorizontalGroup(
                headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headingsLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(nameHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                .addComponent(PriceHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(qtyHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
        );
        headingsLayout.setVerticalGroup(
                headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headingsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(headingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameHeading)
                                        .addComponent(qtyHeading)
                                        .addComponent(PriceHeading))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(navbarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(updateCart, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(checkoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(17, 17, 17))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(headings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(navbarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(headings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(checkoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(updateCart, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
        );
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void checkoutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (cart.getProducts().size() == 0) {
            new emptyCartError().setVisible(true);
        } else {
            this.dispose();
            new Checkout().setVisible(true);
        }
    }

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new Homepage().setVisible(true);
    }

    private Product removeFromCartList(String name) {
        for (Product x : this.cart.getProducts().keySet()) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }

    private void saveToFile() {
        try {
            FileOutputStream outstream = new FileOutputStream("src/ObjectFiles/cart.dat", false);
            ObjectOutputStream os = new ObjectOutputStream(outstream);
            os.writeObject(cart);
            os.close();
        }catch (Exception f) {
            f.printStackTrace();
        }
    }


    private void onUpdateCart(java.awt.event.ActionEvent evt) {
        this.dispose();
        new CartForm().setVisible(true);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CartForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CartForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CartForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CartForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton checkoutBtn;
    private javax.swing.JLabel PriceHeading;
    private javax.swing.JLabel qtyHeading;
    private javax.swing.JLabel nameHeading;
    private javax.swing.JPanel headings;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel total;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton updateCart;
    private javax.swing.JLabel navbar;
    private javax.swing.JPanel navbarPanel;
    private javax.swing.JPanel panelForScroll;

}