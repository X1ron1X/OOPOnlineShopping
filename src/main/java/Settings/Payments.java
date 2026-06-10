package Settings;

import Dbcon.DBConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

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

    private int userId;
    int cardY = 20;

    public Payments(int userId) {
        this.userId = userId;

        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0, 0, 1550, 790);

        // ================= MAIN PANEL =================
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
        addCard = new JButton("+ Add Card");
        addGcash = new JButton("+ Add GCash");

        addBank.setBounds(80, 600, 400, 50);
        addCard.setBounds(530, 600, 400, 50);
        addGcash.setBounds(980, 600, 400, 50);

        pnlMain.add(addBank);
        pnlMain.add(addCard);
        pnlMain.add(addGcash);

        // ================= BANK PANEL =================
        pnlBank = new JPanel(null);
        pnlBank.setBounds(400, 100, 700, 500);
        pnlBank.setBackground(Color.WHITE);
        pnlBank.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pnlBank.setVisible(false);
        add(pnlBank);

        JLabel bankTitle = new JLabel("Bank Information");
        bankTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        bankTitle.setBounds(180, 30, 400, 40);
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
        cancelBank = new JButton("Cancel");

        saveBank.setBounds(180, 380, 140, 40);
        cancelBank.setBounds(360, 380, 140, 40);

        pnlBank.add(saveBank);
        pnlBank.add(cancelBank);

        // ================= CARD PANEL =================
        pnlCard = new JPanel(null);
        pnlCard.setBounds(400, 100, 700, 550);
        pnlCard.setBackground(Color.WHITE);
        pnlCard.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pnlCard.setVisible(false);
        add(pnlCard);

        JLabel cardTitle = new JLabel("Card Information");
        cardTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        cardTitle.setBounds(180, 30, 400, 40);
        pnlCard.add(cardTitle);

        cardName1 = new JTextField();
        cardNum1 = new JTextField();
        expiry1 = new JTextField();
        cvv1 = new JTextField();

        JLabel c1 = new JLabel("Card Holder");
        c1.setBounds(80, 120, 150, 30);
        pnlCard.add(c1);

        cardName1.setBounds(250, 120, 350, 35);
        pnlCard.add(cardName1);

        JLabel c2 = new JLabel("Card Number");
        c2.setBounds(80, 190, 150, 30);
        pnlCard.add(c2);

        cardNum1.setBounds(250, 190, 350, 35);
        pnlCard.add(cardNum1);

        JLabel c3 = new JLabel("Expiry");
        c3.setBounds(80, 260, 150, 30);
        pnlCard.add(c3);

        expiry1.setBounds(250, 260, 350, 35);
        pnlCard.add(expiry1);

        JLabel c4 = new JLabel("CVV");
        c4.setBounds(80, 330, 150, 30);
        pnlCard.add(c4);

        cvv1.setBounds(250, 330, 350, 35);
        pnlCard.add(cvv1);

        saveCard = new JButton("Save");
        cancelCard = new JButton("Cancel");

        saveCard.setBounds(180, 430, 140, 40);
        cancelCard.setBounds(360, 430, 140, 40);

        pnlCard.add(saveCard);
        pnlCard.add(cancelCard);

        // ================= GCASH PANEL =================
        pnlGcash = new JPanel(null);
        pnlGcash.setBounds(400, 100, 700, 450);
        pnlGcash.setBackground(Color.WHITE);
        pnlGcash.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pnlGcash.setVisible(false);
        add(pnlGcash);

        JLabel gTitle = new JLabel("GCash Information");
        gTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        gTitle.setBounds(180, 30, 400, 40);
        pnlGcash.add(gTitle);

        gcashName1 = new JTextField();
        gcashNum1 = new JTextField();

        JLabel g1 = new JLabel("Full Name");
        g1.setBounds(80, 140, 150, 30);
        pnlGcash.add(g1);

        gcashName1.setBounds(250, 140, 350, 35);
        pnlGcash.add(gcashName1);

        JLabel g2 = new JLabel("GCash Number");
        g2.setBounds(80, 220, 150, 30);
        pnlGcash.add(g2);

        gcashNum1.setBounds(250, 220, 350, 35);
        pnlGcash.add(gcashNum1);

        saveGcash = new JButton("Save");
        cancelGcash = new JButton("Cancel");

        saveGcash.setBounds(180, 330, 140, 40);
        cancelGcash.setBounds(360, 330, 140, 40);

        pnlGcash.add(saveGcash);
        pnlGcash.add(cancelGcash);

        // ================= ACTIONS =================
        addBank.addActionListener(this);
        addCard.addActionListener(this);
        addGcash.addActionListener(this);

        saveBank.addActionListener(this);
        saveCard.addActionListener(this);
        saveGcash.addActionListener(this);

        cancelBank.addActionListener(this);
        cancelCard.addActionListener(this);
        cancelGcash.addActionListener(this);

        loadPayments();
    }

    // ================= ACTION HANDLER =================
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBank) {
            pnlMain.setVisible(false);
            pnlBank.setVisible(true);

        } else if (e.getSource() == addCard) {
            pnlMain.setVisible(false);
            pnlCard.setVisible(true);

        } else if (e.getSource() == addGcash) {
            pnlMain.setVisible(false);
            pnlGcash.setVisible(true);

        } else if (e.getSource() == cancelBank
                || e.getSource() == cancelCard
                || e.getSource() == cancelGcash) {

            pnlBank.setVisible(false);
            pnlCard.setVisible(false);
            pnlGcash.setVisible(false);
            pnlMain.setVisible(true);

        } else if (e.getSource() == saveBank) {

            PaymentDAO.insertBank(userId,
                    bankName1.getText(),
                    accName1.getText(),
                    accNum1.getText());

            loadPayments();
            closePanels();

        } else if (e.getSource() == saveCard) {

            PaymentDAO.insertCard(userId,
                    cardName1.getText(),
                    cardNum1.getText(),
                    expiry1.getText(),
                    cvv1.getText());

            loadPayments();
            closePanels();

        } else if (e.getSource() == saveGcash) {

            PaymentDAO.insertGcash(userId,
                    gcashName1.getText(),
                    gcashNum1.getText());

            loadPayments();
            closePanels();
        }
    }

    private void closePanels() {
        pnlBank.setVisible(false);
        pnlCard.setVisible(false);
        pnlGcash.setVisible(false);
        pnlMain.setVisible(true);
    }

    // ================= LOAD =================
    private void loadPayments() {

        cardsPanel.removeAll();
        paymentCards.clear();
        cardY = 20;

        loadBanks();
        loadCards();
        loadGcash();

        cardsPanel.revalidate();
        cardsPanel.repaint();
    }

    private void loadBanks() {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM banks WHERE user_id=?");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                createCard("BANK",
                        rs.getInt("bid"),
                        rs.getString("bname"),
                        rs.getString("holder") + " | " + rs.getString("bnum"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadCards() {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM cards WHERE user_id=?");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                createCard("CARD",
                        rs.getInt("cid"),
                        rs.getString("holder"),
                        rs.getString("cnum"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadGcash() {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM gcashs WHERE user_id=?");
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                createCard("GCASH",
                        rs.getInt("gid"),
                        rs.getString("name"),
                        rs.getString("gnum"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ================= UI CARD =================
    private void createCard(String type, int id, String name, String details) {

        JPanel card = new JPanel(null);
        card.setBounds(0, cardY, 1250, 100);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        card.putClientProperty("id", id);
        card.putClientProperty("type", type);

        JLabel t = new JLabel(type);
        t.setBounds(20, 10, 200, 30);

        JLabel n = new JLabel(name);
        n.setBounds(20, 50, 300, 25);

        JLabel d = new JLabel(details);
        d.setBounds(320, 50, 500, 25);
        d.setForeground(Color.GRAY);

        JButton del = new JButton("Delete");
        del.setBounds(1100, 30, 100, 35);

        del.addActionListener(e -> {
            deletePayment(type, id);
            loadPayments();
        });

        card.add(t);
        card.add(n);
        card.add(d);
        card.add(del);

        cardsPanel.add(card);
        paymentCards.add(card);

        cardY += 120;
    }

    private void deletePayment(String type, int id) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = switch (type) {
                case "BANK" -> "DELETE FROM banks WHERE bid=?";
                case "CARD" -> "DELETE FROM cards WHERE cid=?";
                default -> "DELETE FROM gcash WHERE gid=?";
            };

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ================= DAO =================
    static class PaymentDAO {

        static void insertBank(int userId, String bank, String name, String num) {
            try {
                Connection conn = DBConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(
                        "INSERT INTO banks(user_id, bname, holder, bnum) VALUES (?,?,?,?)"
                );
                pst.setInt(1, userId);
                pst.setString(2, bank);
                pst.setString(3, name);
                pst.setString(4, num);
                pst.executeUpdate();
            } catch (Exception e) { e.printStackTrace(); }
        }

        static void insertCard(int userId, String name, String num, String exp, String cvv) {
            try {
                Connection conn = DBConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(
                        "INSERT INTO cards(user_id, holder, cnum, edate, cvv) VALUES (?,?,?,?,?)"
                );
                pst.setInt(1, userId);
                pst.setString(2, name);
                pst.setString(3, num);
                pst.setString(4, exp);
                pst.setString(5, cvv);
                pst.executeUpdate();
            } catch (Exception e) { e.printStackTrace(); }
        }

        static void insertGcash(int userId, String name, String num) {
            try {
                Connection conn = DBConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(
                        "INSERT INTO gcashs(user_id, name, gnum) VALUES (?, ?, ?)"
                );
                pst.setInt(1, userId);
                pst.setString(2, name);
                pst.setString(3, num);
                pst.executeUpdate();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}