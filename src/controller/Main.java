package controller;

import java.sql.SQLException;
import java.util.Scanner;
import model.ConnectionDB;
import model.Customer;
import model.Product;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectionDB.getConnection();
        menuSelect();
    }

    public static void menuSelect() throws SQLException {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("\n====== SALES ======");
        System.out.println(
                "[1] Cliente" + "\n[2] Produtos" + "\n[3] Pedido" + "\n[4] Sair");
        int op = sc1.nextInt();

        switch (op) {
            case 1:
                menuCustomer();
                break;
            case 2:
                menuProduct();
                break;
            case 3:
                menuOrder();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.print("Opcao invalida!");
                menuSelect();
                break;
        }

        sc1.close();
    }

    private static void menuProduct() throws SQLException {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("\n======PRODUTOS======");
        System.out.println(
                "[1] Cadastrar Produto" + "\n[2] Listar Produtos" + "\n[3] Atualizar produto" + "\n[4] Deletar produto"
                        + "\n[5] Voltar" + "\n[6] Sair");
        int op = sc1.nextInt();

        switch (op) {
            case 1:
                createProduct();
                break;
            case 2:
                listProduct();
                break;
            case 3:
                updateProduct();
            case 4:
                deleteProduct();
                break;
            case 5:
                menuSelect();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.print("Opcao invalida!");
                menuSelect();
                break;
        }
        sc1.close();
    }

    private static void menuOrder() throws SQLException {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("\n======PEDIDOS======");
        System.out.println(
                "[1] Gerar pedido" + "\n[2] Listar Pedidos" + "\n[3] Atualizar pedido" + "\n[4] Deletar pedido"
                        + "\n[5] Voltar" + "\n[6] Sair");
        int op = sc1.nextInt();

        switch (op) {
            case 1:
                createOrder();
                break;
            case 2:
                listOrder();
                break;
            case 3:
                updateOrder();
            case 4:
                deleteOrder();
                break;
            case 5:
                menuOrder();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.print("Opcao invalida!");
                menuSelect();
                break;
        }
        sc1.close();

    }

    public static void menuCustomer() throws SQLException {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("\n======CLIENTES======");
        System.out.println(
                "[1] Cadastrar cliente" + "\n[2] Listar Clientes" + "\n[3] Atualizar" + "\n[4] Deletar cadastro"
                        + "\n[5] Voltar" + "\n[6] Sair");
        int op = sc1.nextInt();

        switch (op) {
            case 1:
                createCustomer();
                break;
            case 2:
                readCustomer();
                break;
            case 3:
                updateCustomer();
            case 4:
                deleteCustomer();
                break;
            case 5:
                menuSelect();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.print("Opcao invalida!");
                menuSelect();
                break;
        }
        sc1.close();
    }

    private static void createProduct() throws SQLException {
        Scanner sc1 = new Scanner(System.in);
        Product product = new Product();
        ProductDao productDao = new ProductDao();

        System.out.println("=============Cadastro de Produto=============");
        System.out.println("Insira o nome do item:");
        product.setNameProduct(sc1.nextLine());
        System.out.println("Insira o valor do item:");
        product.setPrice(sc1.nextDouble());
        System.out.println("Insira estoque do item:");
        product.setStock(sc1.nextInt());

        productDao.saveProduct(new Product(product.getNameProduct(), product.getPrice(), product.getStock()));
        menuProduct();
        sc1.close();

    }

    private static void listProduct() throws SQLException {
        ProductDao productDao = new ProductDao();
        productDao.getProduct();
        menuProduct();
    }

    private static void deleteProduct() throws SQLException {
        ProductDao productDao = new ProductDao();
        productDao.deleteProduct();
        menuProduct();
    }

    private static void updateProduct() {
        //menuProduct();
    }

    public static void createCustomer() throws SQLException {
        try (Scanner sc1 = new Scanner(System.in)) {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();

            System.out.println("Nome:");
            customer.setName(sc1.nextLine());
            System.out.println("Endereco:");
            customer.setAdress(sc1.nextLine());
            System.out.println("Email:");
            customer.setEmail(sc1.next());
            System.out.println("Senha de acesso:");
            customer.setPass(sc1.nextInt());
            customerDao.save(customer);
            menuCustomer();
            sc1.close();
        }
    }

    public static void readCustomer() throws SQLException {
        CustomerDao customerDao = new CustomerDao();
        customerDao.read();
        menuCustomer();
    }

    private static void updateCustomer() throws SQLException {
        try (Scanner sc1 = new Scanner(System.in)) {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();

            System.out.println("Nome:");
            customer.setName(sc1.nextLine());
            System.out.println("Endereco:");
            customer.setAdress(sc1.nextLine());
            System.out.println("Email:");
            customer.setEmail(sc1.next());
            System.out.println("Senha de acesso:");
            customer.setPass(sc1.nextInt());

            customerDao.update(customer);
            sc1.close();

        }
    }

    private static void deleteCustomer() {
        CustomerDao customerDao = new CustomerDao();
        customerDao.delete();
    }

}
