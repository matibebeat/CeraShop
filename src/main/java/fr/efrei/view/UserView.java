package fr.efrei.view;
import fr.efrei.domain.Role;

import java.util.Scanner;

public class UserView {


    public void UserViewMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
        System.out.println("----User View----");
        System.out.println("1. Create user");
        System.out.println("2. Delete user");
        System.out.println("3. Update user");
        System.out.println("4. Exit");

        choice = scanner.nextInt();
        switch (choice){
            case 1:
                createUser();
                break;
            case 2:
                deleteUser();
                break;
            case 3:
                updateUser();
                break;
            default:
                System.out.println("Invalid choice");
        }
        }while (choice != 4);
    }

    public Role login() {
        System.out.println("Login");
        System.out.println("email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();

        return Role.MANAGER;
    }
    public void createUser() {
        System.out.println("Create User");
        System.out.println("email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();
        System.out.println("role: (1. MANAGER, 2. CASHIER)");
        int role = scanner.nextInt();
        Role roleUser = null;
        switch (role){
            case 1:
                roleUser = Role.MANAGER;
                break;
            case 2:
                roleUser = Role.CASHIER;
                break;
            default:
                System.out.println("Invalid choice");
        }
        System.out.println("firstName:");
        String firstName = scanner.nextLine();
        System.out.println("lastName:");
        String lastName = scanner.nextLine();
        /*
        * add here the code to create a user in the database
        * */

    }

    public void deleteUser() {
        System.out.println("Delete User");
        System.out.println("email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        /*
        * add here the code to delete a user in the database
        * */

    }

    public void updateUser(){
        System.out.println("wich user do you want to update?");
        System.out.println("email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("password:");
        String password = scanner.nextLine();
        System.out.println("role: (1. MANAGER, 2. CASHIER)");
        int role = scanner.nextInt();
        Role roleUser = null;
        switch (role){
            case 1:
                roleUser = Role.MANAGER;
                break;
            case 2:
                roleUser = Role.CASHIER;
                break;
            default:
                System.out.println("Invalid choice");
        }
        System.out.println("firstName:");
        String firstName = scanner.nextLine();
        System.out.println("lastName:");
        String lastName = scanner.nextLine();
        /*
        * add here the code to update a user in the database
         */
    }


}
