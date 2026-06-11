package com.mycompany.ooponlineshopping;


import com.mycompany.AddToCart.AddToCart;
import com.mycompany.AddToCart.Product;
import com.mycompany.AddToCart.checkout;
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
public class Header extends JFrame implements ActionListener{
    private JButton btnhome,btnsearch,btnsettings,btnorders,btncart;
    private JTextField searchBar;
    private JPanel header;
    private AddToCart cartPanel;
    
   public Header(){
        setSize(1010,600);
        setTitle("Header");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           cartPanel = new AddToCart();
        
        btnhome = new JButton("Home");
        btnhome.setBounds(50,10,100,30);
        btnhome.setForeground(Color.blue);
        add(btnhome);
        
        searchBar = new JTextField("Search...");
        searchBar.setBounds(200,10,300,30);
        add(searchBar);
        
        
         btnsearch = new JButton("Search");
        btnsearch.setBounds(500,10,100,30);
        add(btnsearch);
        
         btnsettings = new JButton("Settings");
        btnsettings.setBounds(630,10,100,30);
        add(btnsettings);
        
        btnorders = new JButton("Orders");
        btnorders.setBounds(760,10,100,30);
        add(btnorders);
        
         btncart = new JButton("Cart");
        btncart.setBounds(890,10,100,30);
        add(btncart);
        
        
        
        header = new JPanel();
        header.setBounds(0,0,1010,50);
        header.setBackground(Color.decode("#23777B"));
        add(header);
        
        btnhome.addActionListener(this);
        btnsettings.addActionListener(this);
        btnorders.addActionListener(this);
        btncart.addActionListener(this);
        
        Product p = new Product(cartPanel);
        p.setBounds(0,60,400,300);
        add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnsettings){
        dispose();
        Settings s = new Settings(userId);
        s.setVisible(true);
        }
         else if(e.getSource() == btnorders){
        dispose();
        Orders o = new Orders(userId);
        o.setVisible(true);
        }
         else if(e.getSource() == btncart){
        dispose();
        Cart c = new Cart(cartPanel);
        c.setVisible(true);
//        cartFrame = new JPanel();
//        cartFrame.setSize(1000,600);
//        cartFrame.setLayout(null);
//        cartPanel.setBounds(0,0,1000,500);
//        cartFrame.add(cartPanel);
//        cartFrame.setVisible(true);

        }
    }
    
}
