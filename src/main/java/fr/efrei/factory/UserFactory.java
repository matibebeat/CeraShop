package fr.efrei.factory;

import fr.efrei.domain.Role;
import fr.efrei.domain.User;
import fr.efrei.util.Helper;

public class UserFactory {
    public static User createUser(String email, String password, Role role, int employeeId, String firstName, String lastName){
        if (Helper.isNullorEmpty(email)||Helper.isNullorEmpty(password) || Helper.isNullorEmpty(firstName) || Helper.isNullorEmpty(lastName) ||  employeeId < 0)
            return null;

        return new User.Builder().setEmail(email)
                .setPassword(password)
                .setRole(role)
                .setEmployeeId(employeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}