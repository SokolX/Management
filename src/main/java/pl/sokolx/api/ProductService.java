package pl.sokolx.api;

import pl.sokolx.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    int getCounterProducts();
    Product getProductByProductName(String productName);
    boolean counterProductIsBiggerThanZero(String productName);
    boolean productNameDoesExist(String productName);
    boolean productByIdDoesExist(Long productId);

}
