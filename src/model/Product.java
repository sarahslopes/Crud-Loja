package model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private int stock;

    public Product() {

    }

    public Product(String nameProduct, double price, int stock) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product id=" + id + ", name=" + nameProduct + ", price=" + price + ", stock=" + stock + "\n";
    }
}
