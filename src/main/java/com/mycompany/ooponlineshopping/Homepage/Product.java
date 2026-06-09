/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ooponlineshopping.Homepage;

/**
 *
 * @author DE TORRES
 */
public class Product {

    String name;
    String description;
    String price;
    String image;
    int quantity;

    public Product(String name,
                   String description,
                   String price,
                   String image,
                   int quantity) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }
}