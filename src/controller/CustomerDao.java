package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.ConnectionDB;
import model.Customer;

public class CustomerDao {

    public void save(Customer customer) throws SQLException {
        try {
          Connection connection = ConnectionDB.getConnection();
          String sql = "INSERT INTO `customer`(name,adress,email,pass) VALUES (?,?,?,?);";
    
          PreparedStatement stmt = connection.prepareStatement(sql);
          stmt.setString(1, customer.getName());
          stmt.setString(2, customer.getAdress());
          stmt.setString(3, customer.getEmail());
          stmt.setInt(4, customer.getPass());
          stmt.execute();
    
          System.out.println("Customer save");
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      public void read() throws SQLException {
        ArrayList<Customer> customerList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnection();
        String sql = "SELECT  * FROM `customer`;";
        Statement stmt = connection.createStatement();
        ResultSet rset = stmt.executeQuery(sql);

        while (rset.next()) {
          Customer customer = new Customer();
          customer.setId(rset.getInt("id"));
          customer.setName(rset.getString("name"));
          customer.setAdress(rset.getString("adress"));
          customer.setEmail(rset.getString("email"));
          customer.setPass(rset.getInt("pass"));

          customerList.add(customer);
          System.out.println(customerList.toString());
        }
      }

      public void update(Customer customer) {
        try {
            Connection connection = ConnectionDB.getConnection();
            String sql = "UPDATE * FROM `customer` SET name =?,adress=?,email=?,pass=? WHERE id = 1;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAdress());
            stmt.setString(3, customer.getEmail());
            stmt.setInt(4, customer.getPass());

            System.out.println("Cadastro atualizado");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cadastro não atualizado");
        }
    }

    public void delete(){
      try {
          Connection connection = ConnectionDB.getConnection();
          String sql = "DELETE FROM `customer` WHERE id =6 ;";
          PreparedStatement stmt = connection.prepareStatement(sql);
          stmt.execute( );
          System.out.println("Customerdeleted");
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Customer not deleted");
      }
  }
}
