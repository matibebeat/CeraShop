package fr.efrei.factory;

import fr.efrei.domain.Product;
import fr.efrei.util.Helper;

public class ProductFactory {
    public static Product createProduct(int id, String description, String size, String color){
        if (Helper.isNullorEmpty(description)||Helper.isNullorEmpty(size) || Helper.isNullorEmpty(color) || id < 0)
            return null;

        return new Product.Builder().setId(id)
                .setDescription(description)
                .setSize(size)
                .setColor(color)
                .build();
    }
}
