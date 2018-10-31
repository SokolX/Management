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
    private ProductDao productDao = ProductDaoImpl.getInstance();
    private ProductValidator productValidator = ProductValidator.getInstance();

    public ProductServiceImpl() {
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

    public void removeProduct(String productName) throws Exception {
        productDao.removeProductByName(productName);
    }

    public boolean isProductExist(String productName) throws IOException {
        Product product = null;
        product = getProductByProductName(productName);
        return product == null;
    }

    public boolean isProductExist(Long productId) throws IOException {
        Product product = null;
        product = getProductByProductId(productId);

        return product == null;
    }

    public boolean isProductOnWarehouse(String productName) {
        try {
            for(Product product : getAllProducts()) {
                if (isProductExist(productName) && product.getProductCount() > 0) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveProduct(Product product) throws IOException, ProductWeightNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductPriceNoPositiveException {
        if (productValidator.isValidate(product)) {
            productDao.saveProduct(product);
            return true;
        }

        return false;
    }
}
