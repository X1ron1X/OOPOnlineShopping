
package Home;



public class Product {

    int productId;
    String name;
    String description;
    double price;
    int quantity;
    String imagePath;

    public Product(
            int productId,
            String name,
            String description,
            double price,
            int quantity,
            String imagePath){

        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }
    
    
    public Product(
        String name,
        String description,
        double price,
        int quantity,
        String imagePath){

    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
    this.imagePath = imagePath;
}
}