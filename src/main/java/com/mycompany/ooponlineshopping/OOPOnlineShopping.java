package com.mycompany.ooponlineshopping;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class OOPOnlineShopping {

    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();

        SwingUtilities.invokeLater(() -> {
            DefaultListModel<String> toShip = new DefaultListModel<>();
            DefaultListModel<String> transit = new DefaultListModel<>();
            DefaultListModel<String> completed = new DefaultListModel<>();

            DatabaseManager.loadOrdersByStatus("Pending", toShip);
            DatabaseManager.loadOrdersByStatus("In Transit", transit);
            DatabaseManager.loadOrdersByStatus("Completed", completed);

            adminDispatch adminWindow = new adminDispatch(toShip, transit, completed);
            customerStatus customerWindow = new customerStatus(toShip, transit, completed);

            adminWindow.setVisible(true);
            customerWindow.setVisible(true);
        });
    }
}