package fr.efrei.view;

import fr.efrei.domain.Customer;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.repository.CustomerRepository;

import java.util.Scanner;
public class CustomerView {
    private CustomerRepository customerDb = CustomerRepository.getRepository();

    public void CustomerViewMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do{

        System.out.println("----Customer Menu----");
        System.out.println("1. Create Customer");
        System.out.println("2. Delete Customer");
        System.out.println("3. Get Customer Purchases");
        System.out.println("4. Exit");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CreateCustomer();
                    break;
                case 2:
                    DeleteCustomer();
                    break;
                case 3:
                    getCustomerPurchases();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (choice != 4);
    }


    public void CreateCustomer() {
        System.out.println("---Create Customer---");
        System.out.println("Name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Phone:");
        long phone = scanner.nextLong();

        Customer customer = CustomerFactory.createCustomer(phone , name,0);
        Customer cust = customerDb.create(customer);
        if (cust != null) {
            System.out.println("Customer created");
        }
        else {
            System.out.println("Customer not created");
        }

    }

    public void DeleteCustomer() {
        System.out.println("---Delete Customer---");
        System.out.println("Phone:");
        Scanner scanner = new Scanner(System.in);
        long phone = scanner.nextLong();

        Boolean isDeleted = customerDb.delete(phone);
        if (isDeleted) {
            System.out.println("Customer deleted");
        }
        else {
            System.out.println("Customer not found");
        }

    }

    public int getCustomerPurchases() {
        System.out.println("---Get Customer Purchases---");
        System.out.println("Phone:");
        Scanner scanner = new Scanner(System.in);
        long phone = scanner.nextLong();
        Customer targetCustomer = customerDb.read(phone);
        if (targetCustomer != null) {
            System.out.println("Customer: " + targetCustomer.getName());
            System.out.println("Purchases: " + targetCustomer.getPurchases());
            return targetCustomer.getPurchases();
        }
        else {
            System.out.println("Customer not found");
        }
        return 0;
    }

}
