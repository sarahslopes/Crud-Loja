package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ConnectionDB;
import model.Product;

public class ProductDao {
    public void saveProduct(Product product) throws SQLException {
        try {
            Connection connection = ConnectionDB.getConnection();
            String sql = "INSERT INTO `product`(name, price,stock) VALUES (?,?,?);";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getNameProduct());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getStock());
            stmt.execute();

            System.out.println("Product save");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getProduct() throws SQLException {
        try {
            ArrayList<Product> productList = new ArrayList<>();
            Connection connection = ConnectionDB.getConnection();
            ResultSet rset = null;
            String sql = "select * from `product`;";
            PreparedStatement stmt = connection.prepareStatement(sql);

            rset = stmt.executeQuery();

            while (rset.next()) {// Recuṕera do banco e salva no objeto
                Product product = new Product();
                product.setId(rset.getInt("id"));
                product.setNameProduct(rset.getString("name"));
                product.setPrice(rset.getDouble("price"));
                product.setStock(rset.getInt("stock"));

                productList.add(product);
            }

            System.out.println(productList.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao gerar lista");
        }
    }

    public void deleteProduct() {
        try {
            Connection connection = ConnectionDB.getConnection();
            String sql = "DELETE FROM `product` WHERE id = 6;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();

            System.out.println("Product deleted");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Product not deleted");
        }
    }
}
