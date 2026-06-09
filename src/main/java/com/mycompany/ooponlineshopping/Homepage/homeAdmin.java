/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ooponlineshopping.Homepage;

/**
 *
 * @author DE TORRES
 */




import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class homeAdmin extends JFrame implements ActionListener {

    ArrayList<Product> products = new ArrayList<>();
    public JLabel title, categories,productImage,productName,productPrice,productImage2,productName2,productPrice2, productImage3, productName3, productPrice3;
    public JButton btnAddItem,searchBtn,btnAdd,btnPlace,btnPay,btnOrder,btnCardAdd,btnCardAdd2,btnCardAdd3;
    public JPanel color;
    public JComboBox<String> btnBox;
    public JPanel card1, card2,card3;
    public ImageIcon productIcon, productIcon2,productIcon3;
    public int nextX = 100;
    public int nextY = 600;
    public JPanel mainPanel;
    public JScrollPane scroll;
    
    



    homeAdmin(){

    

        setTitle("ShopBee");
        setSize(1240, 1240);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1200, 1800));

       scroll = new JScrollPane(mainPanel);
       setContentPane(scroll);

        color = new JPanel();
        color.setLayout(null);
        color.setBackground(new Color(255,191,0)); 
        color.setBounds(0, 0, 1700, 150);
        mainPanel.add(color);


        title = new JLabel("ShopBee");
        title.setBounds(70, 80, 400, 30);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        color.add(title);


       

        
    card1 = new JPanel();
    card1.setLayout(null);
    card1.setBounds(100, 250, 250, 320);
    card1.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
    mainPanel.add(card1);

    
    productIcon = new ImageIcon("regreg.jpeg");
    productImage = new JLabel(productIcon);
    productImage.setBounds(25, 10, 200, 180);
    card1.add(productImage);

    
    productName = new JLabel("Gaming Mouse");
    productName.setBounds(70, 200, 150, 30);
    productName.setFont(new Font("Arial", Font.BOLD, 16));
    card1.add(productName);

    
    productPrice = new JLabel("₱599");
    productPrice.setBounds(100, 230, 100, 30);
    productPrice.setFont(new Font("Arial", Font.BOLD, 18));
    card1.add(productPrice);

    
    btnCardAdd = new JButton("Select");
    btnCardAdd.setBounds(50, 270, 150, 30);
    card1.add(btnCardAdd);

        
    card2 = new JPanel();
    card2.setLayout(null);
    card2.setBounds(400, 250, 250, 320);
    card2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
    mainPanel.add(card2);

    productIcon2 = new ImageIcon("regreg.jpeg");
    productImage2 = new JLabel(productIcon2);
    productImage2.setBounds(25, 10, 200, 180);
    card2.add(productImage2);

    productName2 = new JLabel("Wireless Keyboard");
    productName2.setBounds(50, 200, 170, 30);
    productName2.setFont(new Font("Arial", Font.BOLD, 16));
    card2.add(productName2);

    productPrice2 = new JLabel("₱899");
    productPrice2.setBounds(100, 230, 100, 30);
    productPrice2.setFont(new Font("Arial", Font.BOLD, 18));
    card2.add(productPrice2);

    btnCardAdd2 = new JButton("Select");
    btnCardAdd2.setBounds(50, 270, 150, 30);
    card2.add(btnCardAdd2);



    card3 = new JPanel();
    card3.setLayout(null);
    card3.setBounds(700, 250, 250, 320);
    card3.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));
    mainPanel.add(card3);

    productIcon3 = new ImageIcon("headset.jpeg");
    productImage3 = new JLabel(productIcon3);
    productImage3.setBounds(25, 10, 200, 180);
    card3.add(productImage3);

    productName3 = new JLabel("Gaming Headset");
    productName3.setBounds(55, 200, 170, 30);
    productName3.setFont(new Font("Arial", Font.BOLD, 16));
    card3.add(productName3);

    productPrice3 = new JLabel("₱1299");
    productPrice3.setBounds(90, 230, 100, 30);
    productPrice3.setFont(new Font("Arial", Font.BOLD, 18));
    card3.add(productPrice3);

    btnCardAdd3 = new JButton("Select");
    btnCardAdd3.setBounds(50, 270, 150, 30);
    card3.add(btnCardAdd3);



            
    String [] flip  = {"Gaming Mouse", 
                        "Wireless Keyboard", 
                        "Gaming Headset"
                        };

            btnBox = new JComboBox<>(flip);
            btnBox.setBounds(230, 80, 800, 40);
            btnBox.addActionListener(this);
            color.add(btnBox);
            

        
        

            searchBtn = new JButton("Search");
            searchBtn.setBounds(1040, 80, 100, 40);
            searchBtn.addActionListener(this);
            color.add(searchBtn);

            btnAddItem = new JButton("Add Item");
            btnAddItem.setBounds(800, 750, 100, 40);
            btnAddItem.addActionListener(this);
            mainPanel.add(btnAddItem);
            


            categories = new JLabel("Products");
            categories.setBounds(170, 170, 150, 50);
            categories.setFont(new Font("Arial", Font.BOLD, 24));
            categories.setBackground(Color.BLACK);
            mainPanel.add(categories);

        
            btnCardAdd.addActionListener(this);
            btnCardAdd2.addActionListener(this);
            btnCardAdd3.addActionListener(this);


  
    }




    
    public void createProductCard(String name, String desc,
                              String price, String imagePath,
                              int quantity) {

    JPanel newCard = new JPanel();
    newCard.setLayout(null);
    newCard.setBounds(nextX, nextY, 250, 320);
    newCard.setBorder(
            BorderFactory.createLineBorder(Color.GRAY));

    ImageIcon icon = new ImageIcon(imagePath);
    JLabel img = new JLabel(icon);
    img.setBounds(25, 10, 200, 150);
    newCard.add(img);

    JLabel pname = new JLabel(name);
    pname.setBounds(40, 170, 170, 25);
    pname.setFont(new Font("Arial",
            Font.BOLD, 16));
    newCard.add(pname);

    JLabel pprice = new JLabel("₱" + price);
    pprice.setBounds(80, 195, 100, 25);
    pprice.setForeground(Color.RED);
    pprice.setFont(new Font("Arial",
            Font.BOLD, 18));
    newCard.add(pprice);

    JLabel qty = new JLabel("Stock: " + quantity);
    qty.setBounds(75, 220, 100, 25);
    newCard.add(qty);

    JButton select = new JButton("Select");
    select.setBounds(50, 260, 150, 30);

    
    
    
    
    select.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            cart1 c = new cart1(name,desc,"₱" + price,imagePath);

            c.setVisible(true);
        }
    });

    newCard.add(select);
    mainPanel.add(newCard);
    
    nextX += 300;
    if(nextX > 900){
        nextX = 100;
        nextY += 350;
    }

    mainPanel.repaint();
    mainPanel.revalidate();
  
}


  
    
    
    
    
    
    @Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnCardAdd){
    cart1 c = new cart1(
        "Gaming Mouse",
        "RGB Gaming Mouse with 7 programmable buttons.",
        "₱599",
        "regreg.jpeg"
    );
    c.setVisible(true);
}

else if(e.getSource() == btnCardAdd2){
    cart1 c = new cart1(
        "Wireless Keyboard",
        "Mechanical wireless keyboard with RGB lighting.",
        "₱899",
        "regreg.jpeg"
    );
    c.setVisible(true);
}

else if(e.getSource() == btnCardAdd3){
    cart1 c = new cart1(
        "Gaming Headset",
        "Surround sound gaming headset with noise cancellation.",
        "₱1299",
        "headset.jpeg"
    );
    c.setVisible(true);


}   else if(e.getSource() == btnAddItem){

    String name = JOptionPane.showInputDialog("Enter Product Name:");

    String desc = JOptionPane.showInputDialog("Enter Description:");

    String price = JOptionPane.showInputDialog("Enter Price:");

    String quantity = JOptionPane.showInputDialog("Enter Quantity:");

    String image = JOptionPane.showInputDialog("Enter Image File Name:\nExample: headset.jpeg");

    Product p = new Product(name,desc,price,image,Integer.parseInt(quantity));
    products.add(p);

    createProductCard(name,desc,price,image,Integer.parseInt(quantity));
}

    

    setVisible(true);
}
}


