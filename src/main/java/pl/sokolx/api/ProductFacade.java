package pl.sokolx.api;

import pl.sokolx.models.Product;

import java.util.List;

public interface ProductFacade {

    String createProduct(Product product);
    String removeProduct(String productName);
    List<Product> getAllProducts();
}
