package com.mycompany.ooponlineshopping;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class customerStatus extends JFrame {

    private DefaultListModel<String> toShipModel;
    private DefaultListModel<String> transitModel;
    private DefaultListModel<String> completedModel;
    
    private JList<String> customerToShipList;
    private JList<String> customerTransitList;
    private JList<String> customerCompletedList;

    private final Color COLOR_BG = new Color(245, 245, 247);          
    private final Color COLOR_PANEL_BG = Color.WHITE;    
    private final Color COLOR_AMBER = new Color(225, 150, 0);      
    private final Color COLOR_TEXT_DARK = new Color(40, 40, 40); 

    public customerStatus(DefaultListModel<String> toShip, 
                          DefaultListModel<String> transit, 
                          DefaultListModel<String> completed) {
        
        this.toShipModel = toShip;
        this.transitModel = transit;
        this.completedModel = completed;

        setTitle("Customer Order Tracking Panel");
        setSize(950, 520); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        setupUI();
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel yellowHeaderPanel = new JPanel(new BorderLayout(10, 10));
        yellowHeaderPanel.setBackground(COLOR_AMBER);
        yellowHeaderPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JPanel textContainer = new JPanel(new GridLayout(2, 1, 2, 2));
        textContainer.setOpaque(false);
        
        JLabel titleLabel = new JLabel("CUSTOMER PANEL");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        
        JLabel subTitleLabel = new JLabel("Track My Orders");
        subTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subTitleLabel.setForeground(new Color(245, 245, 245));
        
        textContainer.add(titleLabel);
        textContainer.add(subTitleLabel);
        yellowHeaderPanel.add(textContainer, BorderLayout.WEST);

        JButton backBtn = new JButton("Back");
        backBtn.setBackground(Color.WHITE);
        backBtn.setForeground(COLOR_AMBER);
        backBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
        backBtn.setFocusPainted(false);
        backBtn.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JPanel btnWrapper = new JPanel(new GridBagLayout());
        btnWrapper.setOpaque(false);
        btnWrapper.add(backBtn);
        yellowHeaderPanel.add(btnWrapper, BorderLayout.EAST);

        mainPanel.add(yellowHeaderPanel, BorderLayout.NORTH);

        JPanel leftColumn = new JPanel(new BorderLayout(5, 12));
        leftColumn.setBackground(COLOR_PANEL_BG);
        leftColumn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_AMBER, 1, true), 
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));
        
        JLabel leftLabel = new JLabel("Pending Shipment");
        leftLabel.setForeground(COLOR_TEXT_DARK);
        leftLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        leftColumn.add(leftLabel, BorderLayout.NORTH);

        customerToShipList = createStyledList(toShipModel);
        JScrollPane leftScroll = new JScrollPane(customerToShipList);
        leftScroll.setBorder(BorderFactory.createEmptyBorder());
        leftColumn.add(leftScroll, BorderLayout.CENTER);

        JPanel centerColumn = new JPanel(new BorderLayout(5, 12));
        centerColumn.setBackground(COLOR_PANEL_BG);
        centerColumn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_AMBER, 1, true), 
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));
        
        JLabel centerLabel = new JLabel("In Transit");
        centerLabel.setForeground(COLOR_TEXT_DARK);
        centerLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        centerColumn.add(centerLabel, BorderLayout.NORTH);

        customerTransitList = createStyledList(transitModel);
        JScrollPane centerScroll = new JScrollPane(customerTransitList);
        centerScroll.setBorder(BorderFactory.createEmptyBorder());
        centerColumn.add(centerScroll, BorderLayout.CENTER);

        JPanel rightColumn = new JPanel(new BorderLayout(5, 12));
        rightColumn.setBackground(COLOR_PANEL_BG);
        rightColumn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_AMBER, 1, true), 
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));
        
        JLabel rightLabel = new JLabel("Completed");
        rightLabel.setForeground(COLOR_TEXT_DARK);
        rightLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        rightColumn.add(rightLabel, BorderLayout.NORTH);

        customerCompletedList = createStyledList(completedModel);
        JScrollPane rightScroll = new JScrollPane(customerCompletedList);
        rightScroll.setBorder(BorderFactory.createEmptyBorder());
        rightColumn.add(rightScroll, BorderLayout.CENTER);

        JPanel splitGrid = new JPanel(new GridLayout(1, 3, 20, 0));
        splitGrid.setBackground(COLOR_BG);
        splitGrid.add(leftColumn);
        splitGrid.add(centerColumn);
        splitGrid.add(rightColumn);
        
        mainPanel.add(splitGrid, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }

    private JList<String> createStyledList(DefaultListModel<String> model) {
        JList<String> list = new JList<>(model);
        list.setBackground(Color.WHITE);
        list.setForeground(COLOR_TEXT_DARK);
        list.setSelectionBackground(new Color(240, 240, 240));
        list.setSelectionForeground(COLOR_TEXT_DARK);
        list.setFont(new Font("SansSerif", Font.PLAIN, 12));
        list.setFixedCellHeight(28);
        return list;
    }
}