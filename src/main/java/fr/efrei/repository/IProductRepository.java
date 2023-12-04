package fr.efrei.repository;

import fr.efrei.domain.Product;

import java.util.List;

public interface IProductRepository extends IRepository<Product, Integer> {
    public List<Product>getAll();
}
