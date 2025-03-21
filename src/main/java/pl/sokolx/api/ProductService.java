package pl.sokolx.api;

import pl.sokolx.exception.ProductCountNegativeException;
import pl.sokolx.exception.ProductNameEmptyException;
import pl.sokolx.exception.ProductPriceNoPositiveException;
import pl.sokolx.exception.ProductWeightNoPositiveException;
import pl.sokolx.models.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;
    Integer getCountProducts() throws IOException;
    Product getProductByProductName(String productName) throws IOException;
    Product getProductByProductId(Long productId) throws IOException;

    boolean isProductExistByName(String productName);
    boolean isProductExistById(Long productId);
    boolean isProductOnWarehouse(String productName) throws IOException;

    boolean counterProductIsBiggerThanZero(String productName);

    boolean saveProduct(Product product) throws IOException, ProductWeightNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductPriceNoPositiveException;
    void removeProduct(String productName) throws Exception;

}
