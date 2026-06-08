
package com.mycompany.ooponlineshopping;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class Homep extends JFrame implements ActionListener {


    private JLabel title, categories;
    private JButton searchBtn;
    private JButton btnElectronics, btnClothes, btnBag, tnSignUp,btnLogIn,btnCamera,btnLaptops,btnSports,btnAdd,btnPlace,btnPay,btnOrder;
    private JPanel color;
    private JComboBox btnBox;



    Homep(){

        setTitle("ShopBee");
        setSize(1240, 1240);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        color = new JPanel();
        color.setLayout(null);
        color.setBackground(new Color(255,191,0)); 
        color.setBounds(0, 0, 1700, 150);
        add(color);


        title = new JLabel("ShopBee");
        title.setBounds(70, 80, 400, 30);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        color.add(title);

       



        
String [] flip  = {"Electronics", 
                    "Clothes", 
                    "Bag", 
                    "Camera",
                    "Laptops",
                    "Sports"};

         btnBox = new JComboBox<>(flip);
         btnBox.setBounds(230, 80, 800, 40);
         btnBox.addActionListener(this);
         color.add(btnBox);
         

      
       

        searchBtn = new JButton("Search");
        searchBtn.setBounds(1040, 80, 100, 40);
        searchBtn.addActionListener(this);
        color.add(searchBtn);
        


        categories = new JLabel("Categories");
        categories.setBounds(170, 170, 150, 50);
        categories.setFont(new Font("Arial", Font.BOLD, 24));
        categories.setBackground(Color.BLACK);
        add(categories);

       

        
        btnElectronics = new JButton("Electronics");
        btnElectronics.setBounds(170, 240, 150, 60);
        btnElectronics.setBackground(new Color(255,191,0));
        btnElectronics.addActionListener(this);
        add(btnElectronics);

        btnCamera = new JButton("Cameras");
        btnCamera.setBounds(170, 320, 150, 60);
        btnCamera.setBackground(new Color(255,191,0));
        btnCamera.addActionListener(this);
        add(btnCamera);

        btnClothes = new JButton("Clothes");
        btnClothes.setBounds(340, 240, 150, 60);
        btnClothes.setBackground(new Color(255,191,0));
        btnClothes.addActionListener(this);
        add(btnClothes);

        btnLaptops = new JButton("Laptops");
        btnLaptops.setBounds(340, 320, 150, 60);
        btnLaptops.setBackground(new Color(255,191,0));
        btnLaptops.addActionListener(this);
        add(btnLaptops);

        btnBag = new JButton("Bag");
        btnBag.setBounds(510, 240, 150, 60);
        btnBag.setBackground(new Color(255,191,0));
        btnBag.addActionListener(this);
        add(btnBag);

        btnSports = new JButton("Sports");
        btnSports.setBounds(510, 320, 150, 60);
        btnSports.setBackground(new Color(255,191,0));
        btnSports.addActionListener(this);
        add(btnSports);
        
    
        
        btnAdd = new JButton("Add to Cart");
        btnAdd.setBounds(130, 750, 100, 30);
        btnAdd.setBackground(new Color(255,191,0));
        btnAdd.addActionListener(this);
        add(btnAdd);
        
        
        btnPlace = new JButton("Place Orders");
        btnPlace.setBounds(290, 750, 100, 30);
        btnPlace.setBackground(new Color(255,191,0));
        btnPlace.addActionListener(this);
        add(btnPlace);
        
        btnPay = new JButton("Pay");
        btnPay.setBounds(420, 750, 100, 30);
        btnPay.setBackground(new Color(255,191,0));
        btnPay.addActionListener(this);
        add(btnPay);
        
        btnOrder = new JButton("Order Tracking");
        btnOrder.setBounds(550, 750, 100, 30);
        btnOrder.setBackground(new Color(255,191,0));
        btnOrder.addActionListener(this);
        add(btnOrder);
        
        
        
        
        
        
        
        
        
        
        


  
    }



  
    
    
    
    
    
    @Override
public void actionPerformed(ActionEvent e) {

    


}
}


