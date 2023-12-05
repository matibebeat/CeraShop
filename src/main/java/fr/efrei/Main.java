package fr.efrei;
import java.util.Scanner;

import fr.efrei.domain.Role;
import fr.efrei.repository.UserRepository;
import fr.efrei.view.CustomerView;
import fr.efrei.view.UserView;
import fr.efrei.view.ProductView;

import fr.efrei.factory.UserFactory;
import fr.efrei.domain.User;
public class Main {

    private static Role role = null;

    public static void main(String[] args) {
        UserRepository UserDb = UserRepository.getRepository();
        User user = UserFactory.createUser("admin@admin", "1234", Role.MANAGER,1234, "John", "Doe");
        UserDb.create(user);
        MainMenu();
    }

    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        CustomerView customerView = new CustomerView();
        if (role == null) {
            role = userView.login();
        }
        int choice = 0;
        System.out.println("----Cera Shop----");
        System.out.println("1. Manage Products");
        System.out.println("2. Manage Customers");
        if (role == Role.MANAGER) System.out.println("3. Manage Employees");
        System.out.println("4. Exit");
        while (choice != 4) {
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    ProductView.ProductMenu();
                    break;
                case 2:
                    customerView.CustomerViewMenu();
                    break;
                case 3:
                    userView.UserViewMenu();
                    break;
                case 4:
                    role = null;
                    break;
                default:
                    System.out.println("Invalid choice");
            }


        }
    }
}
