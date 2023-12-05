package fr.efrei.view;

import fr.efrei.factory.ProductFactory;
import fr.efrei.domain.Color;
import fr.efrei.domain.Size;
import fr.efrei.domain.Product;
import fr.efrei.repository.ProductRepository;
import fr.efrei.Main;
import java.util.List;
import java.util.Scanner;

public class ProductView {

    public static void ProductMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do{
        System.out.println("----Product Menu----");
        System.out.println("1. Add a product");
        System.out.println("2. Search for a product");
        System.out.println("3. Update a product");
        System.out.println("4. Delete a product");
        System.out.println("5. Display the products in stock");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    AddProduct();
                    break;
                case 2:
                    SearchProduct();
                    break;
                case 3:
                    UpdateProduct();
                    break;
                case 4:
                    DeleteProduct();
                    break;
                case 5:
                    GetAllProducts();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (option != 6);
        Main.MainMenu();
    }

    public static void AddProduct() {
        Product product;
        do {
            System.out.println("\n\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product information ");
            System.out.print("PRODUCT TYPE\n Enter the corresponding number (1,2,3):\n1: Plate\n2: Bowl\n3: Mug");
            int descindex = scanner.nextInt();
            String description = null;
            switch (descindex) {
                case 1:
                    description = "Plate";
                    break;
                case 2:
                    description = "Bowl";
                    break;
                case 3:
                    description = "Mug";
                    return;
            }
            System.out.print("PRODUCT COLOR\n Enter the corresponding number (1 to 9):\n");
            for (Color color : Color.values()) {
                System.out.println(color.ordinal() + ": " + color);
            }
            int colorindex = scanner.nextInt();
            Color selectedcolor = Color.values()[colorindex];

            System.out.print("PRODUCT SIZE\n Enter the corresponding number (1 to 9):\n");
            for (Size size : Size.values()) {
                System.out.println(size.ordinal() + ": " + size);
            }
            int sizeindex = scanner.nextInt();
            Size selectedsize = Size.values()[sizeindex];

            product = ProductFactory.createProduct(description, selectedsize, selectedcolor);
            if (product == null)
                System.out.println("Invalid information");

        } while (product == null) ;

        ProductRepository productRepository = ProductRepository.getRepository();
        productRepository.create(product);

        System.out.println("Product created successfully: " + product);
    }


    public static void SearchProduct(){
        int productid;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Search for a Product : ");
            System.out.print("Product ID : ");
            productid = scan.nextInt();
            if(productid <= 0)
                System.out.println("Invalid information");

        } while (productid <= 0);

        ProductRepository productRepository = ProductRepository.getRepository();
        Product product = productRepository.read(productid);

        if (product != null) {
            System.out.println("The product is: " + product);
        } else {
            System.out.println("No product with this product ID exists");
        }
    }
    public static void UpdateProduct() {
        Product newProduct;
        int productid;
        Scanner scan = new Scanner(System.in);
        System.out.println("Product to Update : ");
        System.out.print("Product ID : ");
        productid = scan.nextInt();

        ProductRepository productRepository = ProductRepository.getRepository();
        Product oldProduct = productRepository.read(productid);
        System.out.println(oldProduct);
        if (oldProduct != null) {
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Update product : ");
                System.out.print("PRODUCT TYPE\n Enter the corresponding number (1,2,3):\n1: Plate\n2: Bowl\n3: Mug");
                int descindex = scanner.nextInt();
                String description = null;
                switch (descindex) {
                    case 1:
                        description = "Plate";
                        break;
                    case 2:
                        description = "Bowl";
                        break;
                    case 3:
                        description = "Mug";
                        return;
                }
                System.out.print("PRODUCT COLOR\n Enter the corresponding number (1 to 9):\n");
                for (Color color : Color.values()) {
                    System.out.println(color.ordinal() + ": " + color);
                }
                int colorindex = scanner.nextInt();
                Color selectedcolor = Color.values()[colorindex];

                System.out.print("PRODUCT SIZE\n Enter the corresponding number (1 to 9):\n");
                for (Size size : Size.values()) {
                    System.out.println(size.ordinal() + ": " + size);
                }
                int sizeindex = scanner.nextInt();
                Size selectedsize = Size.values()[sizeindex];

                newProduct = ProductFactory.createProduct(description, selectedsize, selectedcolor);

                if(newProduct == null)
                    System.out.println("Wrong information entered");
            } while (newProduct == null);
            productRepository.update(newProduct);
            System.out.println("Product updated successfully: " + newProduct);
        } else {
            System.out.println("No product with this product ID exists");
        }
    }

    public static void DeleteProduct() {
        int productid;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Delete a Product : ");
            System.out.print("Product ID : ");
            productid = scan.nextInt();
            if (productid <= 0)
                System.out.println("Invalid product ID");
        } while (productid <= 0);

        ProductRepository productRepository = ProductRepository.getRepository();
        Product productToDelete = productRepository.read(productid);

        if (productToDelete != null) {
            productRepository.delete(productToDelete.getId());
            System.out.println("Product deleted successfully: " + productToDelete);
        } else {
            System.out.println("No product with this product ID exists");
        }
    }

    public static void GetAllProducts() {
        ProductRepository productRepository = ProductRepository.getRepository();
        List<Product> allProducts = productRepository.getAll();

        if (!allProducts.isEmpty()) {
            System.out.println("All Products:");
            for (Product product : allProducts) {
                System.out.println(product);
            }
        } else {
            System.out.println("No products found.");
        }
    }
}