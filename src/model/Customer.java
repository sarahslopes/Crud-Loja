package model;
/**
 * Customer
 */
public class Customer {
    private int id;
    private String name;
    private String adress;
    private String email;
    private int pass;

    public Customer(){
        
    }
    
    public Customer(String name, String adress, String email, int pass) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Customer adress=" + adress + ", email=" + email + ", id=" + id + ", name=" + name  + "\n";
    }
}