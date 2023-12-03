package fr.efrei.factory;

import fr.efrei.domain.Customer;
import fr.efrei.util.Helper;

public class CustomerFactory {
    public static Customer createCustomer(long phone, String name, int purchases){
        if (Helper.isNullorEmpty(name)|| phone < 0 || purchases < 0)
            return null;

        return new Customer.Builder().setPhone(phone)
                .setName(name)
                .setPurchases(purchases)
                .build();
    }
}
