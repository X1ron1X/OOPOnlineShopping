
package Home;

import Dbcon.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;





public class ProductDAO {

    public void insertProduct(Home.Product p){

    try{

        Connection con = DBConnection.getConnection();

        if (con == null) {
            System.out.println("CONNECTION IS NULL!");
            return;
        }

        String sql =
        "INSERT INTO products(product_name, description, price, quantity, image_path) VALUES(?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, p.name);
        pst.setString(2, p.description);
        pst.setDouble(3, p.price);
        pst.setInt(4, p.quantity);
        pst.setString(5, p.imagePath);

        int rows = pst.executeUpdate();

        System.out.println("INSERT SUCCESS, ROWS: " + rows);

        pst.close();
        con.close();

    } catch(Exception e){
        System.out.println("INSERT FAILED:");
        e.printStackTrace();
    }
}
    
    
    public void deleteProduct(int productId){

    try{
        Connection con = DBConnection.getConnection();

        String sql =
                "DELETE FROM products WHERE product_id = ?";

        PreparedStatement pst =
                con.prepareStatement(sql);

        pst.setInt(1, productId);

        pst.executeUpdate();

    }catch(Exception e){
        e.printStackTrace();
    }

}
    
    
    public ArrayList<Home.Product> getAllProducts() {
    ArrayList<Home.Product> products = new ArrayList<>();

    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM products";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while(rs.next()) {
            Home.Product p = new Home.Product(
                rs.getInt("product_id"),        
                rs.getString("product_name"),   
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getInt("quantity"),
                rs.getString("image_path")      
            );
            products.add(p);
        }

        rs.close();
        pst.close();
        con.close();

    } catch(Exception e) {
        e.printStackTrace();
    }

    return products;
}


}