package pl.sokolx.service;

import pl.sokolx.api.ProductDao;
import pl.sokolx.api.ProductService;
import pl.sokolx.dao.ProductDaoImpl;
import pl.sokolx.exception.ProductCountNegativeException;
import pl.sokolx.exception.ProductNameEmptyException;
import pl.sokolx.exception.ProductPriceNoPositiveException;
import pl.sokolx.exception.ProductWeightNoPositiveException;
import pl.sokolx.models.Product;
import pl.sokolx.validator.ProductValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance = null;
    private final ProductDao productDao = ProductDaoImpl.getInstance();
    private final ProductValidator productValidator = ProductValidator.getInstance();

    List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public static ProductServiceImpl getInstance() {
        if(instance == null) {
            instance = new ProductServiceImpl();
        }

        return instance;
    }

    @Override
    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    @Override
    public Integer getCountProducts() throws IOException {
        return getAllProducts().size();
    }

    @Override
    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            boolean isFoundProduct = product.getProductName().equals(productName);

            if (isFoundProduct) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product getProductByProductId(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            boolean isFoundProduct = product.getProductId().equals(productId);

            if (isFoundProduct) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean isProductExistByName(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductExistById(Long productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isProductOnWarehouse(String productName) {
        try {
            for(Product product : getAllProducts()) {
                if (isProductExistByName(productName) && product.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean counterProductIsBiggerThanZero(String productName) {

        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean saveProduct(Product product) throws IOException, ProductWeightNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductPriceNoPositiveException {
        if (productValidator.isValidate(product)) {
            productDao.saveProduct(product);
            return true;
        }

        return false;
    }

    public void removeProduct(String productName) throws Exception {
        productDao.removeProductByName(productName);
    }
}
