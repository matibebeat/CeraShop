package fr.efrei.repository;

import fr.efrei.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static ProductRepository repository = null;
    private List<Product> productDB = null;
    private ProductRepository() { productDB = new ArrayList<>( );}

    public static ProductRepository getRepository() {
        //creating the singleton
        if (repository == null) {
            repository = new ProductRepository();
        }
        return repository;
    }
    @Override
    public  Product create(Product product) {
        boolean success = productDB.add(product);
        if (success)
            return product;
        else return null;
    }

    @Override
    public Product read(Integer productID) {
        Product product = productDB.stream()
                .filter(s -> s.getId() == (productID))
                .findAny()
                .orElse(null);
        return product;
    }

    @Override
    public Product update(Product NewProduct){
        Product OldProduct = read(NewProduct.getId()-1);
        if (OldProduct == null)
            return null;
        boolean success = delete(NewProduct.getId()-1);
        if (success){
            boolean successAdded = productDB.add(NewProduct);
            if (successAdded)
                return NewProduct;
            else return null;
        }
        return null;
    }

    @Override
    public boolean delete(Integer productCode) {
        Product productToDel = read(productCode);
        boolean success = productDB.remove(productToDel);
        return success;
    }

    @Override
    public List<Product>getAll() {
        return productDB;
    }
}