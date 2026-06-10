package com.mycompany.AddToCart;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Khyran Zarsuela
 */

public class Product extends JPanel implements ActionListener {

    private JButton addBag;
    private JButton addFruit;

    private JPanel bagImage;
    private JPanel fruitImage;

    private JLabel bagName;
    private JLabel fruitName;

    private JLabel bagPrice;
    private JLabel fruitPrice;

    private AddToCart cartGUI;

    private ProductItem bagProduct;
    private ProductItem fruitProduct;

    public Product(AddToCart cartGUI) {

        this.cartGUI = cartGUI;

        setSize(400,300);
        setLayout(null);

        bagProduct =new ProductItem(1,"Bag ni Luffy",1499,null);

        fruitProduct = new ProductItem(2,"Luffy's Devil Fruit Original",25000,null);

        bagImage = new JPanel();
        bagImage.setBounds(20,20,80,80);
        bagImage.setBackground(Color.LIGHT_GRAY);
        add(bagImage);

        bagName =new JLabel("Bag ni Luffy");
        bagName.setBounds(120,20,200,20);
        add(bagName);

        bagPrice =new JLabel("P 1499");
        bagPrice.setBounds(120,50,100,20);
        add(bagPrice);

        addBag =new JButton("Add To Cart");
        addBag.setBounds(120, 75,150,30);
        add(addBag);


        fruitImage = new JPanel();
        fruitImage.setBounds(20,140,80,80);
        fruitImage.setBackground(Color.LIGHT_GRAY);
        add(fruitImage);

        fruitName =new JLabel("Luffy's Devil Fruit Original");
        fruitName.setBounds(120,140,250,20);
        add(fruitName);

        fruitPrice = new JLabel("P 25000");
        fruitPrice.setBounds(120,170,100,20);
        add(fruitPrice);

        addFruit =new JButton("Add To Cart");
        addFruit.setBounds( 120,195,150,30);
        add(addFruit);

        addBag.addActionListener(this);
        addFruit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addBag){
            cartGUI.addItem(bagProduct);
            JOptionPane.showMessageDialog(this,"Bag ni Luffy added to cart");
        }
        else if(e.getSource() == addFruit){
            cartGUI.addItem(fruitProduct);
            JOptionPane.showMessageDialog(this,"Luffy's Devil Fruit added to cart");
        }
    }
}