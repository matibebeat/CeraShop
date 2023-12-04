package fr.efrei.repository;

import fr.efrei.domain.Customer;

import java.util.List;

public interface ICustomerRepository extends IRepository<Customer, Long> {
    public List<Customer>getAll();
}
