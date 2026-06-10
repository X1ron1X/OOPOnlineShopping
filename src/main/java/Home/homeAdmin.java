package Home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class homeAdmin extends JFrame implements ActionListener {

    ArrayList<Product> products = new ArrayList<>();
    public JLabel title, categories;
    public JButton btnAddItem, searchBtn, btnCardAdd, btnCardAdd2, btnCardAdd3;
    public JPanel color;
    public JComboBox<String> btnBox;
    public JPanel card1, card2, card3;
    public ImageIcon productIcon, productIcon2, productIcon3;
    public int nextX = 100;
    public int nextY = 600;
    public JPanel mainPanel;
    public JScrollPane scroll;

    homeAdmin() {
        setTitle("ShopBee");
        setSize(1240, 1240);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(1200, 1800));

        scroll = new JScrollPane(mainPanel);
        setContentPane(scroll);

        color = new JPanel();
        color.setLayout(null);
        color.setBackground(new Color(255, 191, 0));
        color.setBounds(0, 0, 1700, 150);
        mainPanel.add(color);

        title = new JLabel("ShopBee");
        title.setBounds(70, 80, 400, 30);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        color.add(title);

        categories = new JLabel("Products");
        categories.setBounds(170, 170, 150, 50);
        categories.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(categories);

        
        String[] flip = {"Gaming Mouse", "Wireless Keyboard", "Gaming Headset"};
        btnBox = new JComboBox<>(flip);
        btnBox.setBounds(230, 80, 800, 40);
        btnBox.addActionListener(this);
        color.add(btnBox);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(1040, 80, 100, 40);
        searchBtn.addActionListener(this);
        color.add(searchBtn);

        btnAddItem = new JButton("Add Item");
        btnAddItem.setBounds(800, 750, 100, 40);
        btnAddItem.addActionListener(this);
        mainPanel.add(btnAddItem);

        
        setupDemoCards();

       
        loadProducts();

       
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void setupDemoCards() {
       
        card1 = new JPanel();
        card1.setLayout(null);
        card1.setBounds(100, 250, 250, 320);
        card1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mainPanel.add(card1);

        productIcon = new ImageIcon("regreg.jpeg");
        JLabel productImage = new JLabel(productIcon);
        productImage.setBounds(25, 10, 200, 180);
        card1.add(productImage);

        JLabel productName = new JLabel("Gaming Mouse");
        productName.setBounds(70, 200, 150, 30);
        productName.setFont(new Font("Arial", Font.BOLD, 16));
        card1.add(productName);

        JLabel productPrice = new JLabel("₱599");
        productPrice.setBounds(100, 230, 100, 30);
        productPrice.setFont(new Font("Arial", Font.BOLD, 18));
        card1.add(productPrice);

        btnCardAdd = new JButton("Select");
        btnCardAdd.setBounds(50, 270, 150, 30);
        card1.add(btnCardAdd);
        btnCardAdd.addActionListener(this);

        // Repeat for card2, card3...
    }

    public void createProductCard(int productId, String name, String desc, String price, String imagePath, int quantity) {
        JPanel newCard = new JPanel();
        newCard.setLayout(null);
        newCard.setBounds(nextX, nextY, 250, 320);
        newCard.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        ImageIcon icon = new ImageIcon(imagePath);
        JLabel img = new JLabel(icon);
        img.setBounds(25, 10, 200, 150);
        newCard.add(img);

        JLabel pname = new JLabel(name);
        pname.setBounds(40, 170, 170, 25);
        pname.setFont(new Font("Arial", Font.BOLD, 16));
        newCard.add(pname);

        JLabel pprice = new JLabel("₱" + price);
        pprice.setBounds(80, 195, 100, 25);
        pprice.setForeground(Color.RED);
        pprice.setFont(new Font("Arial", Font.BOLD, 18));
        newCard.add(pprice);

        JLabel qty = new JLabel("Stock: " + quantity);
        qty.setBounds(75, 220, 100, 25);
        newCard.add(qty);

        JButton select = new JButton("Select");
        select.setBounds(50, 260, 150, 30);
        newCard.add(select);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(50, 290, 150, 25);
        newCard.add(deleteBtn);

        select.addActionListener(e -> {
            cart1 c = new cart1(name, desc, "₱" + price, imagePath);
            c.setVisible(true);
        });

        deleteBtn.addActionListener(e -> {
            ProductDAO dao = new ProductDAO();
            dao.deleteProduct(productId);
            mainPanel.remove(newCard);
            mainPanel.revalidate();
            mainPanel.repaint();
        });

        nextX += 300;
        if (nextX > 900) {
            nextX = 100;
            nextY += 350;
        }

        mainPanel.add(newCard);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void loadProducts() {
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> list = dao.getAllProducts();
        System.out.println("Products loaded: " + list.size());

        for (Product p : list) {
            createProductCard(
                p.productId,
                p.name,
                p.description,
                String.valueOf(p.price),
                p.imagePath,
                p.quantity
            );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddItem) {
            String name = JOptionPane.showInputDialog("Enter Product Name:");
            String desc = JOptionPane.showInputDialog("Enter Description:");
            String price = JOptionPane.showInputDialog("Enter Price:");
            String quantity = JOptionPane.showInputDialog("Enter Quantity:");
            String image = JOptionPane.showInputDialog("Enter Image File Name:");

            Product p = new Product(name, desc, Double.parseDouble(price), Integer.parseInt(quantity), image);
            products.add(p);

            ProductDAO dao = new ProductDAO();
            dao.insertProduct(p);

            JOptionPane.showMessageDialog(this, "Item Added+0");

            createProductCard(0, name, desc, price, image, Integer.parseInt(quantity));
        }
    }
}
