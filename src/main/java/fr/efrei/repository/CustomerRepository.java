package fr.efrei.repository;

import fr.efrei.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static CustomerRepository repository = null;
    private List<Customer> customerDB = null;
    private CustomerRepository() { customerDB = new ArrayList<>( );}

    public static CustomerRepository getRepository() {
        //creating the singleton
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }
    @Override
    public  Customer create(Customer customer) {
        boolean success = customerDB.add(customer);
        if (success)
            return customer;
        else return null;
    }

    @Override
    public Customer read(Long custphone) {
        Customer customer = customerDB.stream()
                .filter(s -> s.getPhone() == (custphone))
                .findAny()
                .orElse(null);
        return customer;
    }

    @Override
    public Customer update(Customer newCustomer){
        Customer oldCustomer = read(newCustomer.getPhone());
        if (oldCustomer == null)
            return null;
        boolean success = delete(newCustomer.getPhone());
        if (success){
            boolean successAdded = customerDB.add(newCustomer);
            if (successAdded)
                return newCustomer;
            else return null;
        }
        return null;
    }

    @Override
    public boolean delete(Long custphone) {
        Customer custToDel = read(custphone);
        boolean success = customerDB.remove(custToDel);
        return success;
    }

    @Override
    public List<Customer>getAll() {
        return customerDB;
    }
}
