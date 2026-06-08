package Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Ron
 */

//This Class let's the user to Register new Cashless Payments Like Bank, Cards, and Gcash. This class also let's the user edit the registered cashless payments

public class Payments extends JPanel implements ActionListener {
    
    Color PALATINATE = new Color(104, 40, 96);
    JPanel pnlMain, pnlBank, pnlCard, pnlGcash, cardsPanel;
    JScrollPane scroll;
    JButton addBank, addCard, addGcash;
    JButton saveBank, saveCard, saveGcash;
    JButton cancelBank, cancelCard, cancelGcash;
    JTextField bankName1, accName1, accNum1;
    JTextField cardName1, cardNum1, expiry1, cvv1;
    JTextField gcashName1, gcashNum1;
    ArrayList<JPanel> paymentCards = new ArrayList<>();
    JPanel selectedCard = null;
    
    int cardY = 20;
    String paymentType = "";

    public Payments() {

        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0, 0, 1550, 790);
        
        pnlMain = new JPanel(null);
        pnlMain.setBounds(0, 0, 1550, 790);
        pnlMain.setBackground(new Color(245, 245, 245));
        add(pnlMain);
        
        JLabel title = new JLabel("Payment Methods");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setBounds(80, 30, 400, 40);
        pnlMain.add(title);
        
        cardsPanel = new JPanel(null);
        cardsPanel.setBackground(new Color(245, 245, 245));
        
        scroll = new JScrollPane(cardsPanel);
        scroll.setBounds(80, 100, 1300, 450);
        scroll.setBorder(null);
        pnlMain.add(scroll);
        
        addBank = new JButton("+ Add Bank");
        addBank.setBounds(80, 600, 400, 50);
        addBank.setBackground(Color.WHITE);
        addBank.setForeground(PALATINATE);
        addBank.setFocusPainted(false);
        addBank.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pnlMain.add(addBank);
        
        addCard = new JButton("+ Add Card");
        addCard.setBounds(530, 600, 400, 50);
        addCard.setBackground(Color.WHITE);
        addCard.setForeground(PALATINATE);
        addCard.setFocusPainted(false);
        addCard.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pnlMain.add(addCard);
        
        addGcash = new JButton("+ Add GCash");
        addGcash.setBounds(980, 600, 400, 50);
        addGcash.setBackground(Color.WHITE);
        addGcash.setForeground(PALATINATE);
        addGcash.setFocusPainted(false);
        addGcash.setFont(new Font("Segoe UI", Font.BOLD, 18));
        pnlMain.add(addGcash);
        
        pnlBank = new JPanel(null);
        pnlBank.setBounds(400, 100, 700, 500);
        pnlBank.setBackground(Color.WHITE);
        pnlBank.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pnlBank.setVisible(false);
        add(pnlBank);
        
        JLabel bankTitle = new JLabel("Bank Information");
        bankTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        bankTitle.setBounds(180, 30, 300, 40);
        pnlBank.add(bankTitle);
        
        JLabel bankName = new JLabel("Bank Name");
        bankName.setBounds(80, 120, 150, 30);
        pnlBank.add(bankName);
        
        bankName1 = new JTextField();
        bankName1.setBounds(250, 120, 350, 35);
        pnlBank.add(bankName1);
        
        JLabel accName = new JLabel("Account Name");
        accName.setBounds(80, 190, 150, 30);
        pnlBank.add(accName);
        
        accName1 = new JTextField();
        accName1.setBounds(250, 190, 350, 35);
        pnlBank.add(accName1);
        
        JLabel accNum = new JLabel("Account Number");
        accNum.setBounds(80, 260, 150, 30);
        pnlBank.add(accNum);
        
        accNum1 = new JTextField();
        accNum1.setBounds(250, 260, 350, 35);
        pnlBank.add(accNum1);
        
        saveBank = new JButton("Save");
        saveBank.setBounds(180, 380, 140, 40);
        saveBank.setBackground(PALATINATE);
        saveBank.setForeground(Color.WHITE);
        saveBank.setFocusPainted(false);
        pnlBank.add(saveBank);
        
        cancelBank = new JButton("Cancel");
        cancelBank.setBounds(360, 380, 140, 40);
        cancelBank.setBackground(Color.GRAY);
        cancelBank.setForeground(Color.WHITE);
        cancelBank.setFocusPainted(false);
        pnlBank.add(cancelBank);
        
        pnlCard = new JPanel(null);
        pnlCard.setBounds(400, 100, 700, 550);
        pnlCard.setBackground(Color.WHITE);
        pnlCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pnlCard.setVisible(false);
        add(pnlCard);
        
        JLabel cardTitle = new JLabel("Card Information");
        cardTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        cardTitle.setBounds(180, 30, 300, 40);
        pnlCard.add(cardTitle);

        JLabel cardName = new JLabel("Card Holder");
        cardName.setBounds(80, 120, 150, 30);
        pnlCard.add(cardName);
        
        cardName1 = new JTextField();
        cardName1.setBounds(250, 120, 350, 35);
        pnlCard.add(cardName1);
        
        JLabel cardNum = new JLabel("Card Number");
        cardNum.setBounds(80, 190, 150, 30);
        pnlCard.add(cardNum);
        
        cardNum1 = new JTextField();
        cardNum1.setBounds(250, 190, 350, 35);
        pnlCard.add(cardNum1);
        
        JLabel expiry = new JLabel("Expiry Date");
        expiry.setBounds(80, 260, 150, 30);
        pnlCard.add(expiry);
        
        expiry1 = new JTextField();
        expiry1.setBounds(250, 260, 350, 35);
        pnlCard.add(expiry1);
        
        JLabel cvv = new JLabel("CVV");
        cvv.setBounds(80, 330, 150, 30);
        pnlCard.add(cvv);
        
        cvv1 = new JTextField();
        cvv1.setBounds(250, 330, 350, 35);
        pnlCard.add(cvv1);
        
        saveCard = new JButton("Save");
        saveCard.setBounds(180, 430, 140, 40);
        saveCard.setBackground(PALATINATE);
        saveCard.setForeground(Color.WHITE);
        saveCard.setFocusPainted(false);
        pnlCard.add(saveCard);
        
        cancelCard = new JButton("Cancel");
        cancelCard.setBounds(360, 430, 140, 40);
        cancelCard.setBackground(Color.GRAY);
        cancelCard.setForeground(Color.WHITE);
        cancelCard.setFocusPainted(false);
        pnlCard.add(cancelCard);
        
        pnlGcash = new JPanel(null);
        pnlGcash.setBounds(400, 100, 700, 450);
        pnlGcash.setBackground(Color.WHITE);
        pnlGcash.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pnlGcash.setVisible(false);
        add(pnlGcash);
        
        JLabel gcashTitle = new JLabel("GCash Information");
        gcashTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        gcashTitle.setBounds(180, 30, 350, 40);
        pnlGcash.add(gcashTitle);
        
        JLabel gcashName = new JLabel("Full Name");
        gcashName.setBounds(80, 140, 150, 30);
        pnlGcash.add(gcashName);
        
        gcashName1 = new JTextField();
        gcashName1.setBounds(250, 140, 350, 35);
        pnlGcash.add(gcashName1);
        
        JLabel gcashNum = new JLabel("GCash Number");
        gcashNum.setBounds(80, 220, 150, 30);
        pnlGcash.add(gcashNum);
        
        gcashNum1 = new JTextField();
        gcashNum1.setBounds(250, 220, 350, 35);
        pnlGcash.add(gcashNum1);
        
        saveGcash = new JButton("Save");
        saveGcash.setBounds(180, 330, 140, 40);
        saveGcash.setBackground(PALATINATE);
        saveGcash.setForeground(Color.WHITE);
        saveGcash.setFocusPainted(false);
        pnlGcash.add(saveGcash);
        
        cancelGcash = new JButton("Cancel");
        cancelGcash.setBounds(360, 330, 140, 40);
        cancelGcash.setBackground(Color.GRAY);
        cancelGcash.setForeground(Color.WHITE);
        cancelGcash.setFocusPainted(false);
        pnlGcash.add(cancelGcash);
        
        addBank.addActionListener(this);
        addCard.addActionListener(this);
        addGcash.addActionListener(this);
        saveBank.addActionListener(this);
        saveCard.addActionListener(this);
        saveGcash.addActionListener(this);
        cancelBank.addActionListener(this);
        cancelCard.addActionListener(this);
        cancelGcash.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBank) {
            paymentType = "BANK";
            pnlMain.setVisible(false);
            pnlBank.setVisible(true);
        }else if (e.getSource() == addCard) {
            paymentType = "CARD";
            pnlMain.setVisible(false);
            pnlCard.setVisible(true);
        }else if (e.getSource() == addGcash) {
            paymentType = "GCASH";
            pnlMain.setVisible(false);
            pnlGcash.setVisible(true);
        }else if (e.getSource() == cancelBank || e.getSource() == cancelCard || e.getSource() == cancelGcash) {
            pnlBank.setVisible(false);
            pnlCard.setVisible(false);
            pnlGcash.setVisible(false);
            pnlMain.setVisible(true);
        }else if (e.getSource() == saveBank) {
            createPaymentCard("Bank", accName1.getText(), bankName1.getText()
            );
            pnlBank.setVisible(false);
            pnlMain.setVisible(true);
        }else if (e.getSource() == saveCard) {
            createPaymentCard("Card", cardName1.getText(), cardNum1.getText()
            );
            pnlCard.setVisible(false);
            pnlMain.setVisible(true);
        }else if (e.getSource() == saveGcash) {
            createPaymentCard("GCash", gcashName1.getText(), gcashNum1.getText()
            );
            pnlGcash.setVisible(false);
            pnlMain.setVisible(true);
        }
    }
    
    public void createPaymentCard(
            String type,
            String name,
            String details
    ) {
        
        JPanel card = new JPanel(null);
        card.setBounds(0, cardY, 1250, 100);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel paymentType = new JLabel(type);
        paymentType.setFont(new Font("Segoe UI", Font.BOLD, 20));
        
        paymentType.setBounds(20, 10, 200, 30);
        card.add(paymentType);
        
        JLabel paymentName = new JLabel(name);
        paymentName.setBounds(20, 50, 300, 25);
        card.add(paymentName);
        
        JLabel paymentDetails = new JLabel(details);
        paymentDetails.setBounds(320, 50, 400, 25);
        paymentDetails.setForeground(Color.GRAY);
        card.add(paymentDetails);
        
        JButton edit = new JButton("Edit");
        edit.setBounds(980, 30, 100, 35);
        edit.setBackground(PALATINATE);
        edit.setForeground(Color.WHITE);
        edit.setFocusPainted(false);
        card.add(edit);
        
        JButton delete = new JButton("Delete");
        delete.setBounds(1100, 30, 100, 35);
        delete.setBackground(Color.GRAY);
        delete.setForeground(Color.WHITE);
        delete.setFocusPainted(false);
        card.add(delete);
        
        edit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                pnlMain.setVisible(false);
                if (type.equals("Bank")) {
                    
                    pnlBank.setVisible(true);
                    accName1.setText(name);
                    bankName1.setText(details);
                    
                } else if (type.equals("Card")) {
                    
                    pnlCard.setVisible(true);
                    cardName1.setText(name);
                    cardNum1.setText(details);
                    
                }else if (type.equals("GCash")) {
                    
                    pnlGcash.setVisible(true);
                    gcashName1.setText(name);
                    gcashNum1.setText(details);
                    
                }
            }
        });
        
        delete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardsPanel.remove(card);
                paymentCards.remove(card);
                cardsPanel.repaint();
                cardsPanel.revalidate();
            }
        });
        
        paymentCards.add(card);
        cardsPanel.add(card);
        cardY += 120;
        cardsPanel.setPreferredSize(new Dimension(1250, cardY));
        cardsPanel.repaint();
        cardsPanel.revalidate();
    }
}