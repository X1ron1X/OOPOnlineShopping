/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.AddToCart;

/**
 *
 * @author Khyran Zarsuela
 */
public class CartItem {

    private ProductItem product;
    private int quantity;

    public CartItem(ProductItem product) {
        this.product = product;
        this.quantity = 1;
    }

    public ProductItem getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
    this.quantity = quantity;
}
    
    public void increaseQuantity() {
        quantity++;
    }

    public void decreaseQuantity() {

        if(quantity > 1){
            quantity--;
        }
    }

    public double getSubtotal() {

        return quantity *
               product.getProductPrice();
    }
}