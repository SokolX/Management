package pl.sokolx.facade;

import pl.sokolx.api.ProductFacade;
import pl.sokolx.api.ProductService;
import pl.sokolx.exception.ProductCountNegativeException;
import pl.sokolx.exception.ProductNameEmptyException;
import pl.sokolx.exception.ProductPriceNoPositiveException;
import pl.sokolx.exception.ProductWeightNoPositiveException;
import pl.sokolx.models.Product;
import pl.sokolx.service.ProductServiceImpl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {

    private final static ProductFacade instance = new ProductFacadeImpl();
    private final ProductService productService = ProductServiceImpl.getInstance();

    private ProductFacadeImpl() {

    }

    public static ProductFacade getInstance() {
        return ProductFacadeImpl.instance;
    }

    @Override
    public String createProduct(Product product) {
        try {
            productService.saveProduct(product);
            return "Create product "  + product;
        } catch (IOException e) {
            e.printStackTrace();
            return "[IOException] Error while add product to database";
        } catch (ProductPriceNoPositiveException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductWeightNoPositiveException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductNameEmptyException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductCountNegativeException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String removeProduct(String productName) {
        try {
            productService.removeProduct(productName);
            return "Removed product";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            return productService.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
