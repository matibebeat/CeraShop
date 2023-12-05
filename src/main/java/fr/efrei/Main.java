package fr.efrei;
import java.util.Scanner;

import fr.efrei.domain.Role;
import fr.efrei.view.CustomerView;
import fr.efrei.view.UserView;


public class Main {
    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        CustomerView customerView = new CustomerView();
        Role role = userView.login();
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
                    //ProductView productView = new ProductView();
                    break;
                case 2:
                    customerView.CustomerViewMenu();
                    break;
                case 3:
                    userView.UserViewMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
            }


        }
    }
}
