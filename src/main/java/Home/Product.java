package Home;

public class Product {

    public int productId;
    public String name;
    public String description;
    public double price;
    public int quantity;
    public String imagePath;

  
    public Product(String name, String description, double price, int quantity, String imagePath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }

    
    public Product(int productId, String name, String description, double price, int quantity, String imagePath) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }
}