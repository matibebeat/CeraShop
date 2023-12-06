package fr.efrei.factory;

import fr.efrei.domain.Role;
import fr.efrei.domain.User;
import fr.efrei.util.Helper;

public class UserFactory {
    private static int lastEmployeeId = 0;
    public static User createUser(String email, String password, Role role, String firstName, String lastName){
        if (Helper.isNullorEmpty(email)||Helper.isNullorEmpty(password) || Helper.isNullorEmpty(firstName) || Helper.isNullorEmpty(lastName))
            return null;

        return new User.Builder().setEmail(email)
                .setPassword(password)
                .setRole(role)
                .setEmployeeId(++lastEmployeeId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
    }
}