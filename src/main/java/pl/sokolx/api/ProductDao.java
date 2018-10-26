package pl.sokolx.api;

import pl.sokolx.models.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {

    void saveProduct(Product product) throws FileNotFoundException;
    void saveProducts(List<Product> products) throws FileNotFoundException;
    void removeProductById(Long productId);
    void removeProductByName(String productName);
    List<Product> getAllProducts() throws IOException;
    Product getProductById(Long productId);
    Product getProductByProductName(String productName);

}
