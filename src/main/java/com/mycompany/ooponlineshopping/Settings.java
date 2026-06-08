package com.mycompany.ooponlineshopping;

import Settings.accsetting;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ron
 */

//This is the Jframe of my Setting program

public class Settings extends JFrame implements ActionListener {

    private JButton btnhome, btnsearch, btnsettings, btnorders, btncart;
    private JTextField searchBar;
    private JPanel header;

    public Settings() {
        
        setSize(1565, 800);
        setTitle("Settings");
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        Font navFont = new Font("Segoe UI", Font.BOLD, 14);
        
        header = new JPanel();
        header.setLayout(null);
        header.setBounds(0, 0, 1565, 60);
        header.setBackground(Color.decode("#23777B"));
        add(header);
        
        btnhome = new JButton("Home");
        btnhome.setBounds(30, 15, 100, 30);
        btnhome.setFont(navFont);
        header.add(btnhome);
        
        searchBar = new JTextField("Search...");
        searchBar.setBounds(160, 15, 300, 30);
        header.add(searchBar);
        
        btnsearch = new JButton("Search");
        btnsearch.setBounds(470, 15, 100, 30);
        btnsearch.setFont(navFont);
        header.add(btnsearch);
        
        btnsettings = new JButton("Settings");
        btnsettings.setBounds(600, 15, 110, 30);
        btnsettings.setFont(navFont);
        btnsettings.setForeground(Color.BLUE);
        header.add(btnsettings);
        
        btnorders = new JButton("Orders");
        btnorders.setBounds(740, 15, 100, 30);
        btnorders.setFont(navFont);
        header.add(btnorders);
        
        btncart = new JButton("Cart");
        btncart.setBounds(870, 15, 100, 30);
        btncart.setFont(navFont);
        header.add(btncart);
        
        accsetting settingsPanel = new accsetting();
        settingsPanel.setBounds(0, 60, 1400, 740);
        add(settingsPanel);
        
        btnhome.addActionListener(this);
        btnsettings.addActionListener(this);
        btnorders.addActionListener(this);
        btncart.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnhome) {
            dispose();
            new Header().setVisible(true);
        }else if (e.getSource() == btnorders) {
            dispose();
            new Orders().setVisible(true);
        }else if (e.getSource() == btncart) {
            dispose();
            new Cart().setVisible(true);
        }
    }
}