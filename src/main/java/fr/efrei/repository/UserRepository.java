package fr.efrei.repository;

import fr.efrei.domain.Customer;
import fr.efrei.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static  UserRepository repository = null;
    private List<User> userDB = null;
    private UserRepository() { userDB = new ArrayList<>( );}

    public static UserRepository getRepository() {
        //creating the singleton
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }
    @Override
    public  User create(User user) {
        boolean success = userDB.add(user);
        if (success)
            return user;
        else return null;
    }

    @Override
    public User read(Integer employeeID) {
        User user = userDB.stream()
                .filter(s -> s.getEmployeeId() == (employeeID))
                .findAny()
                .orElse(null);
        return user;
    }

    @Override
    public User update(User newUser){
        User oldUser = read(newUser.getEmployeeId()-1);
        if (oldUser == null) {
            return null;
        }
        boolean success = delete(newUser.getEmployeeId()-1);
        if (success){
            boolean successAdded = userDB.add(newUser);
            if (successAdded) {
                return newUser;
            }
            else return null;
        }
        return null;
    }

    @Override
    public boolean delete(Integer employeeID) {
        User userToDel = read(employeeID);
        boolean success = userDB.remove(userToDel);
        return success;
    }

    public User findByEmailAndPassword(String email, String password) {
        User user = userDB.stream()
                .filter(s -> s.getEmail().equals(email) && s.getPassword().equals(password))
                .findAny()
                .orElse(null);
        return user;
    }

    @Override
    public List<User>getAll() {
        return userDB;
    }
}