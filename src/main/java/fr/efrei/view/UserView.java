package fr.efrei.view;

import fr.efrei.domain.Role;
import fr.efrei.domain.User;
import fr.efrei.Main;
import fr.efrei.repository.UserRepository;
import fr.efrei.factory.UserFactory;

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
            System.out.println("5. See a user");
            System.out.println("5. Exit");

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
                case 4:
                    getAllUser();
                case 5:
                    getUser();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while (choice != 5);
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
    public void createUser() {
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
        }
        System.out.print("firstName: ");
        String firstName = scanner.nextLine();
        System.out.print("lastName: ");
        String lastName = scanner.nextLine();


        userRepository.create(UserFactory.createUser(email, password, roleUser, 0, firstName, lastName));

    }

    public void deleteUser() {
        System.out.println("----Delete User----");
        System.out.print("id: ");
        Scanner scanner = new Scanner(System.in);
        int email = scanner.nextInt();

        userRepository.delete(email);
    }

    public void updateUser(){
        System.out.println("----wich user do you want to update?----");
        System.out.print("ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.println("Role: (1. MANAGER, 2. CASHIER)");
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
        System.out.print("FirstName: ");
        String firstName = scanner.nextLine();
        System.out.print("LastName: ");
        String lastName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        userRepository.update(UserFactory.createUser(email, password, roleUser, id, firstName, lastName));
    }

    public void getAllUser(){
        System.out.println("----All users----");
        userRepository.getAll().forEach(user -> System.out.println(user.toString()));
    }

    public void getUser(){
        System.out.println("----Wich user do you want to see?----");
        System.out.print("ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println(userRepository.read(id).toString());
    }


}
