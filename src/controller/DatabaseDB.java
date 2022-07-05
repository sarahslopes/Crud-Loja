package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ConnectionDB;

public class DatabaseDB {
  public static void main(String[] args) throws SQLException {


  }

  public static void createDB() throws SQLException {
    try {
      Connection connection = ConnectionDB.getConnection();
      String sql = "CREATE DATABASE `ecommerce`;";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.execute();
      connection.close();
      System.out.println("Database created");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Database not created");
    }

  }

  public static void tableCustomer(){
    try {
      Connection connection = ConnectionDB.getConnection();
      String sql = "CREATE TABLE IF NOT EXISTS `customer`(id Integer AUTO_INCREMENT,name VARCHAR(30) NOT NULL,adress VARCHAR(30) NOT NULL,email VARCHAR(25) NOT NULL, pass INT NOT NULL,PRIMARY KEY(id),UNIQUE KEY(name)); ";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.execute();
      connection.close();
      System.out.println("Table created");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Table not created");
    }
  }

  public static void tableProduct(){
    try {
      Connection connection = ConnectionDB.getConnection();
      String sql = "CREATE TABLE IF NOT EXISTS `product`(id Integer AUTO_INCREMENT,name VARCHAR(30), price DOUBLE NOT NULL, PRIMARY KEY(id),UNIQUE KEY(name)); ";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.execute();
      connection.close();
      System.out.println("Table created");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Table not created");
    }
  }

  public static void tableOrder(){
    try {
      Connection connection = ConnectionDB.getConnection();
      String sql = "CREATE TABLE IF NOT EXISTS `order`(id Integer AUTO_INCREMENT, Cart_id INT, Customer_id INT NOT NULL, PRIMARY KEY(id),UNIQUE KEY(Customer_id)); ";
      PreparedStatement stmt = connection.prepareStatement(sql);
      stmt.execute();
      connection.close();
      System.out.println("Table created");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Table not created");
    }
  }


  }


