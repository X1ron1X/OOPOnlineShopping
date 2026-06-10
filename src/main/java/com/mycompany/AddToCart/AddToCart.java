package com.mycompany.AddToCart;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class AddToCart extends JPanel implements ActionListener {

    private ArrayList<CartItem> cartItems;

    private JPanel header;
    private JPanel leftPanel;
    private JPanel checkPanel;
    private JPanel check;

    private JPanel cartContainer;
    private JScrollPane scrollPane;

    private JLabel title;
    private JLabel emptyLabel;

    private JLabel totallb;
    private JLabel totaltxt;

    private JLabel lb;
    private JLabel lblb;

    private JLabel overall;
    private JLabel oprice;

    private JButton checkOut;
    private JButton clearCart;

    private double total;

    public AddToCart() {

        setSize(1000,500);
        setLayout(null);

        cartItems = new ArrayList<>();

        title = new JLabel("Your Items");
        title.setBounds(20,10,150,30);
        add(title);

        header = new JPanel();
        header.setBounds(0,0,1000,50);
        header.setBackground(Color.white);
        add(header);

        emptyLabel = new JLabel("No products in cart");
        emptyLabel.setBounds(200,200,200,30);
        add(emptyLabel);

        leftPanel = new JPanel();
        leftPanel.setBounds(0,50,610,450);
        leftPanel.setBackground(Color.white);
        leftPanel.setLayout(null);
        add(leftPanel);

        cartContainer = new JPanel();
        cartContainer.setLayout(null);
        cartContainer.setBackground(Color.white);

        scrollPane = new JScrollPane(cartContainer);
        scrollPane.setBounds(0,0,610,450);

        leftPanel.add(scrollPane);

        checkPanel = new JPanel();
        checkPanel.setBounds(610,350,450,150);
        checkPanel.setBackground(Color.decode("#1A585B"));
        add(checkPanel);

        check = new JPanel();
        check.setBounds(610,50,400,450);
        check.setBackground(Color.decode("#23777B"));
        add(check);

        totallb = new JLabel("Total of Items:");
        totallb.setBounds(620,60,150,100);
        totallb.setForeground(Color.white);
        add(totallb);

        totaltxt = new JLabel("0");
        totaltxt.setBounds(900,60,100,100);
        totaltxt.setForeground(Color.white);
        add(totaltxt);

        lb = new JLabel("Discount Voucher:");
        lb.setBounds(620,80,150,100);
        lb.setForeground(Color.white);
        add(lb);

        lblb = new JLabel("10%");
        lblb.setBounds(900,80,100,100);
        lblb.setForeground(Color.white);
        add(lblb);

        overall = new JLabel("Total");
        overall.setBounds(620,325,100,100);
        overall.setForeground(Color.white);
        add(overall);

        oprice = new JLabel("0");
        oprice.setBounds(900,325,100,100);
        oprice.setForeground(Color.white);
        add(oprice);

        clearCart = new JButton("Clear Cart");
        clearCart.setBounds(625,420,170,30);
        clearCart.setBackground(Color.red);
        clearCart.setForeground(Color.white);
        add(clearCart);

        checkOut = new JButton("Checkout");
        checkOut.setBounds(800,420,170,30);
        checkOut.setBackground(Color.white);
        checkOut.setForeground(Color.black);
        add(checkOut);

        clearCart.addActionListener(this);
        checkOut.addActionListener(this);

        updateTotals();
    }
        public void addItem(ProductItem product){

        for(CartItem item : cartItems){

            if(item.getProduct().getProductId()
                    == product.getProductId()){

                item.increaseQuantity();

                refreshCart();

                return;
            }
        }

        cartItems.add(
                new CartItem(product)
        );

        refreshCart();
    }

    public void removeItem(CartItem item){

        cartItems.remove(item);

        refreshCart();
    }

    public ArrayList<CartItem> getCartItems(){

        return cartItems;
    }
        public void refreshCart(){

        cartContainer.removeAll();

        int y = 10;

        for(CartItem item : cartItems){

            CartItemPanel row =new CartItemPanel(item,this);
            row.setBounds(10,y,570,90);
            cartContainer.add(row);
            y += 100;
        }

        cartContainer.setPreferredSize(new java.awt.Dimension(580,Math.max(y,400)));

        emptyLabel.setVisible(cartItems.isEmpty());

        updateTotals();

        cartContainer.revalidate();
        cartContainer.repaint();
    }
            public void updateTotals(){

        total = 0;

        int totalItems = 0;

        for(CartItem item : cartItems){

            total += item.getSubtotal();

            totalItems += item.getQuantity();
        }

        double discount = total * 0.10;

        double finalTotal =
                total - discount;

        totaltxt.setText(
                String.valueOf(totalItems)
        );

        oprice.setText(
                "P " +
                String.format(
                        "%.2f",
                        finalTotal
                )
        );
    }
                @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == clearCart){

            cartItems.clear();

            refreshCart();
        }

        else if(e.getSource() == checkOut){

            if(cartItems.isEmpty()){
                JOptionPane.showMessageDialog(this,"Cart is empty");
                return;
            }
           checkout c =new checkout(cartItems);
            c.setVisible(true);
        }
    }
}