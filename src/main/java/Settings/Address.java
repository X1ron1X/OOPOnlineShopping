package Settings;

import Dbcon.DBConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ron
 */

//This Class let's the user to Register new Address and edit the registered Address

public class Address extends JPanel implements ActionListener {
    int selectedAddressId = -1;

    Color PALATINATE = new Color(104, 40, 96);
    JPanel pnlAdd, pnledit, cardsPanel;
    JScrollPane scroll;
    JButton add, save, exit;
    JTextField fullname1, hnum1, st1, brgy1,city1, prov1, regi1, pcode1;
    JLabel fullname, hnum, st, brgy,city, prov, regi, pcode;
    private int userId;

    ArrayList<JPanel> addressCards = new ArrayList<>();
    
    JPanel selectedCard = null;

    public Address(int userId) {
        this.userId = userId;
        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0, 0, 1550, 790);
        
        pnlAdd = new JPanel(null);
        pnlAdd.setBounds(0, 0, 1550, 790);
        pnlAdd.setBackground(new Color(245, 245, 245));
        add(pnlAdd);
        
        JLabel title = new JLabel("My Address");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setBounds(80, 30, 300, 40);
        pnlAdd.add(title);
        
        cardsPanel = new JPanel(null);
        cardsPanel.setBackground(new Color(245, 245, 245));
        
        scroll = new JScrollPane(cardsPanel);
        scroll.setBounds(80, 100, 1300, 500);
        scroll.setBorder(null);
        pnlAdd.add(scroll);
        
        
        add = new JButton("+ Add Address");
        add.setBounds(80, 630, 1300, 50);
        add.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add.setBackground(Color.WHITE);
        add.setForeground(PALATINATE);
        add.setFocusPainted(false);
        pnlAdd.add(add);
        
        pnledit = new JPanel(null);
        pnledit.setBounds(350, 70, 700, 600);
        pnledit.setBackground(Color.WHITE);
        pnledit.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        pnledit.setVisible(false);
        add(pnledit);
        
        JLabel editTitle = new JLabel("Address Information");
        editTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        editTitle.setBounds(180, 30, 400, 40);
        pnledit.add(editTitle);
        
        fullname = new JLabel("Full Name");
        fullname.setBounds(80, 100, 150, 30);
        pnledit.add(fullname);
        
        hnum = new JLabel("House Number");
        hnum.setBounds(80, 150, 150, 30);
        pnledit.add(hnum);
        
        st = new JLabel("Street");
        st.setBounds(80, 200, 150, 30);
        pnledit.add(st);
        
        brgy = new JLabel("Barangay");
        brgy.setBounds(80, 250, 150, 30);
        pnledit.add(brgy);
        
        city = new JLabel("City");
        city.setBounds(80, 300, 150, 30);
        pnledit.add(city);
        
        prov = new JLabel("Province");
        prov.setBounds(80, 350, 150, 30);
        pnledit.add(prov);
        
        regi = new JLabel("Region");
        regi.setBounds(80, 400, 150, 30);
        pnledit.add(regi);
        
        pcode = new JLabel("Postal Code");
        pcode.setBounds(80, 450, 150, 30);
        pnledit.add(pcode);
        
        fullname1 = new JTextField();
        fullname1.setBounds(250, 100, 350, 35);
        pnledit.add(fullname1);
        
        hnum1 = new JTextField();
        hnum1.setBounds(250, 150, 350, 35);
        pnledit.add(hnum1);
        
        st1 = new JTextField();
        st1.setBounds(250, 200, 350, 35);
        pnledit.add(st1);
        
        brgy1 = new JTextField();
        brgy1.setBounds(250, 250, 350, 35);
        pnledit.add(brgy1);
        
        city1 = new JTextField();
        city1.setBounds(250, 300, 350, 35);
        pnledit.add(city1);
        
        prov1 = new JTextField();
        prov1.setBounds(250, 350, 350, 35);
        pnledit.add(prov1);
        
        regi1 = new JTextField();
        regi1.setBounds(250, 400, 350, 35);
        pnledit.add(regi1);
        
        pcode1 = new JTextField();
        pcode1.setBounds(250, 450, 350, 35);
        pnledit.add(pcode1);
        
        save = new JButton("Save");
        save.setBounds(180, 530, 140, 40);
        save.setBackground(PALATINATE);
        save.setForeground(Color.WHITE);
        save.setFocusPainted(false);
        pnledit.add(save);
        
        exit = new JButton("Cancel");
        exit.setBounds(360, 530, 140, 40);
        exit.setBackground(Color.GRAY);
        exit.setForeground(Color.WHITE);
        exit.setFocusPainted(false);
        pnledit.add(exit);
        
        add.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);
        loadAddresses();
    }

    @Override
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == add) {

        selectedCard = null;

        fullname1.setText("");
        hnum1.setText("");
        st1.setText("");
        brgy1.setText("");
        city1.setText("");
        prov1.setText("");
        regi1.setText("");
        pcode1.setText("");

        pnlAdd.setVisible(false);
        pnledit.setVisible(true);

    } else if (e.getSource() == exit) {

        pnledit.setVisible(false);
        pnlAdd.setVisible(true);

    } else if (e.getSource() == save) {

        if (selectedCard == null) {

            // ================= INSERT TO DB =================
            AddressDAO.insertAddress(
                    userId,
                    fullname1.getText(),
                    hnum1.getText(),
                    st1.getText(),
                    brgy1.getText(),
                    city1.getText(),
                    prov1.getText(),
                    regi1.getText(),
                    pcode1.getText()
            );
            loadAddresses();
        } else {

            // ================= UPDATE TO DB =================
            AddressDAO.updateAddress(
                    selectedAddressId,
                    fullname1.getText(),
                    hnum1.getText(),
                    st1.getText(),
                    brgy1.getText(),
                    city1.getText(),
                    prov1.getText(),
                    regi1.getText(),
                    pcode1.getText()
            );
            loadAddresses();
            selectedCard = null;
        }

        JOptionPane.showMessageDialog(this, "Address Saved", "Message", JOptionPane.INFORMATION_MESSAGE);
        pnledit.setVisible(false);
        pnlAdd.setVisible(true);
    }
}
    

    public class AddressDAO {

        // ================= INSERT =================
        public static void insertAddress(int userId, String fullName, String houseNo,
                                         String street, String barangay, String city,
                                         String province, String region, String postal) {

            try {
                Connection conn = DBConnection.getConnection();

                String sql = "INSERT INTO addresses "
                        + "(user_id, full_name, house_number, street, barangay, city, province, region, postal_code) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setInt(1, userId);
                pst.setString(2, fullName);
                pst.setString(3, houseNo);
                pst.setString(4, street);
                pst.setString(5, barangay);
                pst.setString(6, city);
                pst.setString(7, province);
                pst.setString(8, region);
                pst.setString(9, postal);

                pst.executeUpdate();

                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // ================= UPDATE =================
        public static void updateAddress(int addressId, String fullName, String houseNo,
                                         String street, String barangay, String city,
                                         String province, String region, String postal) {

            try {
                Connection conn = DBConnection.getConnection();

                String sql = "UPDATE addresses SET full_name=?, house_number=?, street=?, barangay=?, city=?, province=?, region=?, postal_code=? "
                        + "WHERE address_id=?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, fullName);
                pst.setString(2, houseNo);
                pst.setString(3, street);
                pst.setString(4, barangay);
                pst.setString(5, city);
                pst.setString(6, province);
                pst.setString(7, region);
                pst.setString(8, postal);
                pst.setInt(9, addressId);

                pst.executeUpdate();

                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // ================= DELETE =================
        public static void deleteAddress(int addressId) {

            try {
                Connection conn = DBConnection.getConnection();

                String sql = "DELETE FROM addresses WHERE address_id=?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setInt(1, addressId);

                pst.executeUpdate();

                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // ================= GET ALL USER ADDRESSES =================
        public static ResultSet getUserAddresses(int userId) {

            try {
                Connection conn = DBConnection.getConnection();

                String sql = "SELECT * FROM addresses WHERE user_id=?";

                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, userId);

                return pst.executeQuery();

            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
    
    private void loadAddresses() {

    cardsPanel.removeAll();
    addressCards.clear();
    int y = 20;

    try {
        Connection conn = DBConnection.getConnection();

        String sql = "SELECT * FROM addresses WHERE user_id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, userId);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            int addressId = rs.getInt("address_id");
            String fullName = rs.getString("full_name");
            String houseNo = rs.getString("house_number");
            String street = rs.getString("street");
            String city = rs.getString("city");
            String barangay = rs.getString("barangay");
            String province = rs.getString("province");
            String region = rs.getString("region");
            String postal = rs.getString("postal_code");

            JPanel card = new JPanel(null);
            card.setBounds(0, y, 1250, 100);
            card.setBackground(Color.WHITE);
            card.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            card.putClientProperty("addressId", addressId);

            JLabel title = new JLabel("Address " + (addressCards.size() + 1));
            title.setFont(new Font("Segoe UI", Font.BOLD, 20));
            title.setBounds(20, 10, 200, 30);
            card.add(title);

            JLabel name = new JLabel(fullName);
            name.setBounds(20, 50, 250, 25);
            card.add(name);

            JLabel address = new JLabel(houseNo + " " + street + ", " + city + ", " + barangay + ", " + province + ", " + region + ", " + postal);
            address.setBounds(250, 50, 700, 25);
            address.setForeground(Color.GRAY);
            card.add(address);

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

                    selectedCard = card;
                    selectedAddressId = addressId;

                    fullname1.setText(fullName);
                    hnum1.setText(houseNo);
                    st1.setText(street);
                    brgy1.setText(barangay);
                    city1.setText(city);
                    prov1.setText(province);
                    regi1.setText(region);
                    pcode1.setText(postal);

                    pnlAdd.setVisible(false);
                    pnledit.setVisible(true);
                }
            });

            delete.addActionListener(e -> {

                int choice = JOptionPane.showConfirmDialog(
                        null,
                        "Delete this address?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {
                    AddressDAO.deleteAddress(addressId);
                    loadAddresses();
                }
            });

            cardsPanel.add(card);
            y += 120;
        }

        cardsPanel.setPreferredSize(new Dimension(1250, y));

        conn.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    cardsPanel.revalidate();
    cardsPanel.repaint();
}
    
}