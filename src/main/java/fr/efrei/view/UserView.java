package fr.efrei.view;

import fr.efrei.domain.Product;
import fr.efrei.domain.Role;
import fr.efrei.domain.User;
import fr.efrei.Main;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.repository.ProductRepository;
import fr.efrei.repository.UserRepository;
import fr.efrei.factory.UserFactory;

import java.util.List;
import java.util.Scanner;

public class UserView {

    private UserRepository userRepository = UserRepository.getRepository();

    public void UserViewMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----User View----");
            System.out.println("1. Create user");
            System.out.println("2. Delete user");
            System.out.println("3. Update user");
            System.out.println("4. Display all users");
            System.out.println("5. Search for a user");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    CreateUser();
                    break;
                case 2:
                    DeleteUser();
                    break;
                case 3:
                    UpdateUser();
                    break;
                case 4:
                    GetAllUser();
                    break;
                case 5:
                    SearchUser();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (choice != 6);
        Main.MainMenu();
    }

    public Role login() {
        User user = null;
        do {
            System.out.println("----Login----");
            System.out.print("email: ");
            Scanner scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            System.out.print("password: ");
            String password = scanner.nextLine();

            user = userRepository.findByEmailAndPassword(email, password);

            if (user == null) {
                System.out.println("Invalid email or password");

            }
        }while (user == null);
        System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
        return user.getRole();
    }
    public void CreateUser() {
        System.out.println("----Create User----");
        System.out.print("email: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.print("password: ");
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
                return;
        }
        scanner.nextLine();
        System.out.print("FirstName: ");
        String firstName = scanner.nextLine();
        System.out.print("LastName: ");
        String lastName = scanner.nextLine();


        userRepository.create(UserFactory.createUser(email, password, roleUser, firstName, lastName));

    }

    public void DeleteUser() {
        System.out.println("----Delete User----");
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        int email = scanner.nextInt();

        userRepository.delete(email);
    }

    public static void UpdateUser() {
        User newUser;
        int userid;
        System.out.println("\n\n");
        Scanner scan = new Scanner(System.in);
        System.out.println("Updating User ");
        System.out.print("User ID : ");
        userid = scan.nextInt();
        UserRepository userRepository = UserRepository.getRepository();
        User oldUser = userRepository.read(userid);
        System.out.println(oldUser);
        if (oldUser != null) {
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("email: ");
                String email = scanner.nextLine();
                System.out.print("password: ");
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
                        return;
                }
                scanner.nextLine();
                System.out.print("FirstName: ");
                String firstName = scanner.nextLine();
                System.out.print("LastName: ");
                String lastName = scanner.nextLine();

                newUser = UserFactory.createUser(email, password, roleUser,firstName,lastName);

                if (newUser == null)
                    System.out.println("Wrong information entered");
            } while (newUser == null);
            userRepository.update(newUser);
            System.out.println("User updated successfully: " + newUser);
        } else {
            System.out.println("No user with this ID number exists");
        }
    }



    public static void GetAllUser() {
        UserRepository userRepository = UserRepository.getRepository();
        List<User> allUsers = userRepository.getAll();

        if (!allUsers.isEmpty()) {
            System.out.println("All Users:");
            for (User user : allUsers) {
                System.out.println(user);
            }
        } else {
            System.out.println("No users found.");
        }
    }

    public static void SearchUser(){
        int userid;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Search for a User ");
            System.out.print("USER ID : ");
            userid = scan.nextInt();
            if(userid <= 0)
                System.out.println("Invalid information");

        } while (userid <= 0);

        UserRepository userRepository = UserRepository.getRepository();
        User user = userRepository.read(userid);

        if (user != null) {
            System.out.println("The user is: " + user);
        } else {
            System.out.println("No user with this user ID exists");
        }
    }


}
