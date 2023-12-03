package fr.efrei.factory;

import fr.efrei.domain.Product;
import fr.efrei.util.Helper;

public class ProductFactory {
    public static Product createProduct(int id, String description, String size, int quantity){
        if ((Helper.isNullorEmpty(description)||Helper.isNullorEmpty(size)))
            return null;

        return new Product.Builder().setId(id)
                .setDescription(description)
                .setSize(size)
                .setQuantity(quantity)
                .build();
    }
}
