package fr.efrei.view;

import fr.efrei.domain.Customer;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.Main;
import java.util.Scanner;
import java.util.List;
public class  CustomerView {
    private CustomerRepository customerDb = CustomerRepository.getRepository();

    public void CustomerViewMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {

            System.out.println("----Customer Menu----");
            System.out.println("1. Create Customer");
            System.out.println("2. Search for a customer");
            System.out.println("3. Display all the customers");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Add a purchase for a customer");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CreateCustomer();
                    break;
                case 2:
                    SearchCustomer();
                    break;
                case 3:
                    GetAllCustomers();
                    break;
                case 4:
                    UpdateCustomer();
                    break;
                case 5:
                    DeleteCustomer();
                    break;
                case 6:
                    AddCustomerPurchases();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 7);
        Main.MainMenu();
    }


    public void CreateCustomer() {
        System.out.println("---Create Customer---");
        System.out.println("Name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Phone:");
        long phone = scanner.nextLong();

        Customer customer = CustomerFactory.createCustomer(phone, name, 0);
        Customer cust = customerDb.create(customer);
        if (cust != null) {
            System.out.println("Customer created");
        } else {
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
        } else {
            System.out.println("Customer not found");
        }
    }

    public void SearchCustomer() {
        long phone;
        do {
            System.out.println("\n\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("---Search for a customer---");
            System.out.println("Phone:");
            phone = scanner.nextLong();
            if (phone <= 0)
                System.out.println("Invalid information");

        } while (phone <= 0);

        Customer targetCustomer = customerDb.read(phone);

        if (targetCustomer != null) {
            System.out.println("Customer found: " + targetCustomer);
        } else {
            System.out.println("Customer not found");
        }
    }

    public void GetAllCustomers() {
        System.out.println("---Display all customers---");
        CustomerRepository customerRepository = CustomerRepository.getRepository();
        List<Customer> allCustomers = customerRepository.getAll();
        if (!allCustomers.isEmpty()) {
            for (Customer customer : allCustomers) {
                System.out.println(customer);
            }
        } else {
            System.out.println("No customers found.");
        }
    }

    public static void UpdateCustomer() {
        Customer newCustomer;
        Long phone;
        System.out.println("\n\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Customer to Update : ");
        System.out.print("Customer phone number : ");
        phone = scan.nextLong();

        CustomerRepository customerRepository = CustomerRepository.getRepository();
        Customer oldCustomer = customerRepository.read(phone);
        System.out.println(oldCustomer);
        if (oldCustomer != null) {
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Update customer : ");
                System.out.println("Name: ");
                String name = scanner.nextLine();
                System.out.print("Purchases");
                int purchases = scanner.nextInt();

                newCustomer = CustomerFactory.createCustomer(phone, name, purchases);

                if (newCustomer == null)
                    System.out.println("Wrong information entered");
            } while (newCustomer == null);
            customerRepository.update(newCustomer);
            System.out.println("Customer updated successfully: " + newCustomer);
        } else {
            System.out.println("No customer with this phone number exists");
        }
    }

    public void AddCustomerPurchases() {
        Customer newCustomer;
        Long phone;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the customer's phone number:");
        phone = scan.nextLong();

        CustomerRepository customerRepository = CustomerRepository.getRepository();
        Customer oldCustomer = customerRepository.read(phone);
        System.out.println(oldCustomer);
        if (oldCustomer != null) {
            do {
                int NewPurchases = oldCustomer.getPurchases() + 1;

                newCustomer = CustomerFactory.createCustomer(phone, oldCustomer.getName(), NewPurchases);

                if (newCustomer == null)
                    System.out.println("Wrong information entered");
            } while (newCustomer == null);
            customerRepository.update(newCustomer);
            System.out.println("Customer purchases updated successfully: " + newCustomer);
            if (newCustomer.getPurchases() % 5 == 0) {
                System.out.println("This customer's next purchase will be free!");
            } else {
                int purchasesleft = 5 - newCustomer.getPurchases() % 5;
                System.out.println("Only" + purchasesleft + " purchase(s) until this customer's free product!");
            }
        } else {
            System.out.println("No customer with this phone number exists");
        }
    }
}


