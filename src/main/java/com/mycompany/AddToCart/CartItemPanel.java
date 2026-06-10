package com.mycompany.AddToCart;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CartItemPanel extends JPanel implements ActionListener {

    private CartItem item;
    private AddToCart cart;

    private JLabel lblName;
    private JLabel lblPrice;
    private JLabel lblQty;

    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnDelete;
    private JLabel lblImage;

    public CartItemPanel(CartItem item,
                         AddToCart cart) {

        this.item = item;
        this.cart = cart;

        setLayout(null);
        setBackground(Color.decode("#E0E0E0"));
        setBorder(BorderFactory.createLineBorder(Color.black,2,true));

        
        setPreferredSize(
            new java.awt.Dimension(580,90));
        
        lblImage = new JLabel();
        lblImage.setBounds(10,10,60,60);
        lblImage.setIcon(item.getProduct().getProductImage());
        add(lblImage);

        lblName =new JLabel(item.getProduct().getProductName());
        lblName.setBounds(90,10,250,20);
        add(lblName);

        lblPrice =new JLabel("P "+item.getProduct().getProductPrice());
        lblPrice.setBounds(400,10,120,20);
        add(lblPrice);

        btnMinus =new JButton("-");
        btnMinus.setBounds(90,40,50,30);
        add(btnMinus);

        lblQty =new JLabel(String.valueOf(item.getQuantity()));
        lblQty.setBounds(90,45,40,20);
        add(lblQty);

        btnPlus =new JButton("+");
        btnPlus.setBounds(120,40,50,30);
        add(btnPlus);

        btnDelete =new JButton("Delete");
        btnDelete.setBounds(420,40,120,30);
        btnDelete.setBackground(Color.red);
        btnDelete.setForeground(Color.white);
        add(btnDelete);

        btnPlus.addActionListener(this);
        btnMinus.addActionListener(this);
        btnDelete.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnPlus){
            item.increaseQuantity();
        }
        else if(e.getSource() == btnMinus){
            item.decreaseQuantity();
        }

        else if(e.getSource() == btnDelete){
            cart.removeItem(item);
            return;
        }

        lblQty.setText(String.valueOf(item.getQuantity()));
        cart.updateTotals();
    }
}