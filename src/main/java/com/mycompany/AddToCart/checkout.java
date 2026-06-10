package com.mycompany.AddToCart;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;

public class checkout extends JFrame implements ActionListener {

    private JLabel Ordersum,Subto,op,pd,ss,total,paymentm,cod,Address,cashG;
    private JLabel ns,nop,npd,nss,ntotal,cashGName;

    private JButton addC,placeO,address;

    private JPanel orderp,paymentp,header;

    private JRadioButton option1,option2,option3;

    private JTextField addtxt;

    private ArrayList<CartItem> cartItems;

    public checkout(ArrayList<CartItem> cartItems){

        this.cartItems = cartItems;

        setSize(1000,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Ordersum = new JLabel("Order Summary");
        Ordersum.setBounds(40,10,150,20);
        add(Ordersum);

        header = new JPanel();
        header.setBounds(0,0,1000,40);
        header.setBackground(Color.WHITE);
        add(header);

        Subto = new JLabel("Subtotal");
        Subto.setBounds(40,50,100,20);
        Subto.setForeground(Color.WHITE);
        add(Subto);

        op = new JLabel("Original Price");
        op.setBounds(40,80,100,20);
        op.setForeground(Color.WHITE);
        add(op);

        pd = new JLabel("Price Discount");
        pd.setBounds(40,110,120,20);
        pd.setForeground(Color.WHITE);
        add(pd);

        ss = new JLabel("Shipping");
        ss.setBounds(40,140,100,20);
        ss.setForeground(Color.WHITE);
        add(ss);

        total = new JLabel("Total");
        total.setBounds(40,170,100,20);
        total.setForeground(Color.WHITE);
        add(total);

        ns = new JLabel("0");
        ns.setBounds(300,50,200,20);
        ns.setForeground(Color.WHITE);
        add(ns);

        nop = new JLabel("0");
        nop.setBounds(300,80,200,20);
        nop.setForeground(Color.WHITE);
        add(nop);

        npd = new JLabel("0");
        npd.setBounds(300,110,200,20);
        npd.setForeground(Color.WHITE);
        add(npd);

        nss = new JLabel("0");
        nss.setBounds(300,140,200,20);
        nss.setForeground(Color.WHITE);
        add(nss);

        ntotal = new JLabel("0");
        ntotal.setBounds(300,170,200,20);
        ntotal.setForeground(Color.WHITE);
        add(ntotal);

        orderp = new JPanel();
        orderp.setBounds(0,40,500,350);
        orderp.setBackground(Color.decode("#23777B"));
        add(orderp);

        paymentm = new JLabel("Payment Method");
        paymentm.setBounds(650,10,150,20);
        add(paymentm);

        cod = new JLabel("Cash on Delivery");
        cod.setBounds(650,50,150,20);
        add(cod);

        addC = new JButton("+ Add Card");
        addC.setBounds(650,80,180,25);
        add(addC);

        cashG = new JLabel("GCash");
        cashG.setBounds(650,110,100,20);
        add(cashG);

        cashGName = new JLabel("");
        cashGName.setBounds(760,110,150,20);
        add(cashGName);

        Address = new JLabel("Address");
        Address.setBounds(650,140,100,20);
        add(Address);

        address = new JButton("+ Add Address");
        address.setBounds(650,170,180,25);
        add(address);

        addtxt = new JTextField();
        addtxt.setBounds(650,210,250,25);
        addtxt.setVisible(false);
        add(addtxt);

        option1 = new JRadioButton();
        option1.setBounds(900,50,20,20);
        add(option1);

        option2 = new JRadioButton();
        option2.setBounds(900,80,20,20);
        option2.setEnabled(false);
        add(option2);

        option3 = new JRadioButton();
        option3.setBounds(900,110,20,20);
        add(option3);

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        placeO = new JButton("Place Order");
        placeO.setBounds(700,400,150,30);
        add(placeO);

        paymentp = new JPanel();
        paymentp.setBounds(500,40,500,350);
        paymentp.setBackground(Color.WHITE);
        add(paymentp);

        addC.addActionListener(e -> {
            option2.setEnabled(true);
        });

        address.addActionListener(this);
        placeO.addActionListener(this);

        calculateTotals();
    }

    public void calculateTotals(){

        double subtotal = 0;

        for(CartItem item : cartItems){
            subtotal += item.getSubtotal();
        }

        double discount = subtotal * 0.10;
        double shipping = 100;
        double finalTotal = subtotal - discount + shipping;

        ns.setText("P " + subtotal);
        nop.setText("P " + subtotal);
        npd.setText("P -" + discount);
        nss.setText("P " + shipping);
        ntotal.setText("P " + finalTotal);
    }

    public String getSelectedPayment(){

        if(option1.isSelected()){
            return "Cash on Delivery";
        }

        if(option2.isSelected()){
            return "Card";
        }

        if(option3.isSelected()){
            return "GCash";
        }

        return "None";
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == address){
            addtxt.setVisible(true);
        }

        else if(e.getSource() == placeO){

            String payment = getSelectedPayment();
            String location = addtxt.getText();

            if(payment.equals("None")){
                JOptionPane.showMessageDialog(this,"Please select payment method","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(location.isEmpty()){
                JOptionPane.showMessageDialog(this,"Please enter address","Error",JOptionPane.ERROR_MESSAGE);
                return;
            }

            try{

                Connection conn = DBconnection.getConnection();

                double subtotal = 0;

                for(CartItem item : cartItems){
                    subtotal += item.getSubtotal();
                }

                double discount = subtotal * 0.10;
                double shipping = 100;
                double finalTotal = subtotal - discount + shipping;

                String orderSql =
                        "INSERT INTO orders " +
                        "(payment_method,address,total_price) " +
                        "VALUES (?,?,?)";

                PreparedStatement orderPst =
                        conn.prepareStatement(
                                orderSql,
                                Statement.RETURN_GENERATED_KEYS);

                orderPst.setString(1,payment);
                orderPst.setString(2,location);
                orderPst.setDouble(3,finalTotal);

                orderPst.executeUpdate();

                ResultSet rs =
                        orderPst.getGeneratedKeys();

                int orderId = 0;

                if(rs.next()){
                    orderId = rs.getInt(1);
                }

                String itemSql =
                        "INSERT INTO order_items " +
                        "(order_id,product_id,quantity,subtotal) " +
                        "VALUES (?,?,?,?)";

                PreparedStatement itemPst =
                        conn.prepareStatement(itemSql);

                for(CartItem item : cartItems){

                    itemPst.setInt(
                            1,
                            orderId);

                    itemPst.setInt(
                            2,
                            item.getProduct()
                                .getProductId());

                    itemPst.setInt(
                            3,
                            item.getQuantity());

                    itemPst.setDouble(
                            4,
                            item.getSubtotal());

                    itemPst.executeUpdate();
                }

                JOptionPane.showMessageDialog(
                        this,
                        "Order placed successfully!");

                itemPst.close();
                orderPst.close();
                conn.close();

                dispose();

            }
            catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage());
            }
        }
    }
}