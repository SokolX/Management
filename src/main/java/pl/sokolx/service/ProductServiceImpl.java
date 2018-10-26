package pl.sokolx.service;

import pl.sokolx.api.ProductService;
import pl.sokolx.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public int getCounterProducts() {
        return products.size();
    }

    @Override
    public Product getProductByProductName(String productName) {

        for (Product product : products) {
            if(product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean counterProductIsBiggerThanZero(String productName) {

        for (Product product : products) {
            if(product.getProductName().equals(productName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean productNameDoesExist(String productName) {
        for (Product product : products) {
            if(product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean productByIdDoesExist(Long productId) {
        for (Product product : products) {
            if(product.getProductId().equals(productId)) {
                return true;
            }
        }
        return false;
    }
}
