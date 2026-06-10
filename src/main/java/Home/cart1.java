
package Home;

import com.mycompany.ooponlineshopping.Cart;
import com.mycompany.ooponlineshopping.Orders;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class cart1 extends JFrame implements ActionListener {

    public JButton addtocartbtn, buynowbtn;
    public JLabel productName, description, price, imageLabel,quantityLabel, totalLabel;
    public JButton plusBtn, minusBtn;
    public int quantity = 1;
    public int productPriceValue;

    public cart1(String name, String desc, String productPrice, String imagePath) {

        
        
        setTitle("Product Details");
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        ImageIcon icon = new ImageIcon(imagePath);
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(50, 50, 250, 250);
        add(imageLabel);

        
        productName = new JLabel(name);
        productName.setBounds(350, 70, 300, 30);
        productName.setFont(new Font("Arial", Font.BOLD, 22));
        add(productName);

        
        description = new JLabel("<html>" + desc + "</html>");
        description.setBounds(350, 120, 250, 100);
        add(description);

        
        price = new JLabel(productPrice);
        productPriceValue = Integer.parseInt(productPrice.replace("₱", ""));
        price.setBounds(350, 250, 200, 30);
        price.setFont(new Font("Arial", Font.BOLD, 24));
        price.setForeground(Color.RED);
        add(price);

        JLabel qtyText = new JLabel("Quantity:");
        qtyText.setBounds(350, 300, 100, 30);
        qtyText.setFont(new Font("Arial", Font.BOLD, 18));
        add(qtyText);

        minusBtn = new JButton("-");
        minusBtn.setBounds(350, 340, 50, 40);
        minusBtn.addActionListener(this);
        add(minusBtn);

        quantityLabel = new JLabel(String.valueOf(quantity), SwingConstants.CENTER);
        quantityLabel.setBounds(410, 340, 50, 40);
        quantityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        quantityLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(quantityLabel);

        plusBtn = new JButton("+");
        plusBtn.setBounds(470, 340, 50, 40);
        plusBtn.addActionListener(this);
        add(plusBtn);

        JLabel totalText = new JLabel("Total:");
        totalText.setBounds(350, 390, 100, 30);
        totalText.setFont(new Font("Arial", Font.BOLD, 18));
        add(totalText);

        totalLabel = new JLabel("₱" + (productPriceValue * quantity));
        totalLabel.setBounds(420, 390, 150, 30);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(totalLabel);

        
        addtocartbtn = new JButton("Add To Cart");
        addtocartbtn.setBounds(150, 470, 150, 40);
        addtocartbtn.addActionListener(this);
        add(addtocartbtn);

        
        buynowbtn = new JButton("Buy Now");
        buynowbtn.setBounds(350, 470, 150, 40);
        buynowbtn.addActionListener(this);
        add(buynowbtn);

        
        setVisible(true);
    }

    public void updateTotal() {
    quantityLabel.setText(String.valueOf(quantity));
    totalLabel.setText("₱" + (quantity * productPriceValue));
}

   @Override
public void actionPerformed(ActionEvent e) {

    if (e.getSource() == plusBtn) {
        quantity++;
        updateTotal();
    }

    else if (e.getSource() == minusBtn) {
        if (quantity > 1) {
            quantity--;
            updateTotal();
        }
    }

    else if (e.getSource() == addtocartbtn) {
        
        JOptionPane.showMessageDialog(this,"Added to Cart!\n\n"+ "Product: " + productName.getText()+ "\nQuantity: " + quantity+ "\nTotal: ₱" + (quantity * productPriceValue));

        
        


    }

    else if (e.getSource() == buynowbtn) {
        
        JOptionPane.showMessageDialog( this, "Proceeding to Checkout\n\n" + "Product: " + productName.getText() + "\nQuantity: " + quantity+ "\nTotal: ₱" + (quantity * productPriceValue));

        
       
       
        
    }
}
}