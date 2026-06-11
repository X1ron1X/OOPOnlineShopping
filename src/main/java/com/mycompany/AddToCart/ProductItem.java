/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.AddToCart;

import javax.swing.ImageIcon;

/**
 *
 * @author Khyran Zarsuela
 */
public class ProductItem {

    private int productId;
    private String productName;
    private double productPrice;
    private ImageIcon productImage;

    public ProductItem(int productId,
                       String productName,
                       double productPrice,
                       ImageIcon productImage) {

        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public ImageIcon getProductImage() {
        return productImage;
    }
}