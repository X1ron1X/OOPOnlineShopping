package com.mycompany.ooponlineshopping;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class adminDispatch extends JFrame {

    private DefaultListModel<String> toShipModel;
    private DefaultListModel<String> transitModel;
    private DefaultListModel<String> completedModel;
    
    private JList<String> adminToShipList;
    private JList<String> adminTransitList;

    private final Color COLOR_BG = new Color(245, 245, 247);          
    private final Color COLOR_PANEL_BG = Color.WHITE;    
    private final Color COLOR_AMBER = new Color(225, 150, 0);      
    private final Color COLOR_TEXT_DARK = new Color(40, 40, 40); 

    public adminDispatch(DefaultListModel<String> toShip, 
                         DefaultListModel<String> transit, 
                         DefaultListModel<String> completed) {
        
        this.toShipModel = toShip;
        this.transitModel = transit;
        this.completedModel = completed;

        setTitle("Admin Operations Panel");
        setSize(750, 520); 
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
        
        JLabel titleLabel = new JLabel("ADMIN PANEL");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        
        JLabel subTitleLabel = new JLabel("Dispatch Control Room");
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

        adminToShipList = createStyledList(toShipModel);
        JScrollPane leftScroll = new JScrollPane(adminToShipList);
        leftScroll.setBorder(BorderFactory.createEmptyBorder());
        leftColumn.add(leftScroll, BorderLayout.CENTER);
        
        JButton shipBtn = createStyledButton("DISPATCH");
        JPanel shipBtnWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        shipBtnWrapper.setBackground(COLOR_PANEL_BG);
        shipBtnWrapper.add(shipBtn);
        leftColumn.add(shipBtnWrapper, BorderLayout.SOUTH);

        JPanel rightColumn = new JPanel(new BorderLayout(5, 12));
        rightColumn.setBackground(COLOR_PANEL_BG);
        rightColumn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_AMBER, 1, true), 
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));
        
        JLabel rightLabel = new JLabel("In Transit");
        rightLabel.setForeground(COLOR_TEXT_DARK);
        rightLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        rightColumn.add(rightLabel, BorderLayout.NORTH);

        adminTransitList = createStyledList(transitModel);
        JScrollPane rightScroll = new JScrollPane(adminTransitList);
        rightScroll.setBorder(BorderFactory.createEmptyBorder());
        rightColumn.add(rightScroll, BorderLayout.CENTER);
        
        JButton deliverBtn = createStyledButton("MARK DELIVERED");
        JPanel deliverBtnWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        deliverBtnWrapper.setBackground(COLOR_PANEL_BG);
        deliverBtnWrapper.add(deliverBtn);
        rightColumn.add(deliverBtnWrapper, BorderLayout.SOUTH);

        JPanel splitGrid = new JPanel(new GridLayout(1, 2, 20, 0));
        splitGrid.setBackground(COLOR_BG);
        splitGrid.add(leftColumn);
        splitGrid.add(rightColumn);
        
        mainPanel.add(splitGrid, BorderLayout.CENTER);

        shipBtn.addActionListener(e -> {
            int idx = adminToShipList.getSelectedIndex();
            if (idx != -1) {
                String selectedOrder = toShipModel.get(idx);
                DatabaseManager.updateOrderStatus(selectedOrder, "In Transit");
                transitModel.addElement(toShipModel.remove(idx));
            } else {
                showWarning("Please select an item to dispatch.");
            }
        });

        deliverBtn.addActionListener(e -> {
            int idx = adminTransitList.getSelectedIndex();
            if (idx != -1) {
                String selectedOrder = transitModel.get(idx);
                DatabaseManager.updateOrderStatus(selectedOrder, "Completed");
                completedModel.addElement(transitModel.remove(idx));
            } else {
                showWarning("Please select an item to be marked as delivered.");
            }
        });

        add(mainPanel, BorderLayout.CENTER);
    }

    private JList<String> createStyledList(DefaultListModel<String> model) {
        JList<String> list = new JList<>(model);
        list.setBackground(Color.WHITE);
        list.setForeground(COLOR_TEXT_DARK);
        list.setSelectionBackground(COLOR_AMBER);
        list.setSelectionForeground(Color.WHITE);
        list.setFont(new Font("SansSerif", Font.PLAIN, 12));
        list.setFixedCellHeight(28);
        return list;
    }

    private JButton createStyledButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(COLOR_AMBER);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.BOLD, 11));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(8, 22, 8, 22));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void showWarning(String message) {
        UIManager.put("OptionPane.background", COLOR_PANEL_BG);
        UIManager.put("Panel.background", COLOR_PANEL_BG);
        UIManager.put("OptionPane.messageForeground", COLOR_TEXT_DARK);
        JOptionPane.showMessageDialog(this, message, "System Update", JOptionPane.WARNING_MESSAGE);
    }
}