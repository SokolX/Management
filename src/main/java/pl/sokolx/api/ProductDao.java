package pl.sokolx.api;

import pl.sokolx.models.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {

    void saveProduct(Product product) throws IOException;
    void saveProducts(List<Product> products) throws FileNotFoundException;

    void removeProductById(Long productId) throws Exception;
    void removeProductByName(String productName) throws IOException;

    List<Product> getAllProducts() throws IOException;


}
