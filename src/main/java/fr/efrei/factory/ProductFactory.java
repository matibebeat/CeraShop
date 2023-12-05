package fr.efrei.factory;

import fr.efrei.domain.Color;
import fr.efrei.domain.Product;
import fr.efrei.domain.Size;
import fr.efrei.util.Helper;

public class ProductFactory {
    private static int lastProductId = 1;
    public static Product createProduct(String description, Size size, Color color){
        if (Helper.isNullorEmpty(description))
            return null;

        return new Product.Builder().setId(++lastProductId)
                .setDescription(description)
                .setSize(size)
                .setColor(color)
                .build();
    }
}
