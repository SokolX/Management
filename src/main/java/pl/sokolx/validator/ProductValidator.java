package pl.sokolx.validator;

import pl.sokolx.exception.ProductCountNegativeException;
import pl.sokolx.exception.ProductNameEmptyException;
import pl.sokolx.exception.ProductPriceNoPositiveException;
import pl.sokolx.exception.ProductWeightNoPositiveException;
import pl.sokolx.models.Product;

public class ProductValidator {

    private static ProductValidator instance = null;

    private ProductValidator() {

    }

    public static ProductValidator getInstance() {
        if (instance == null) {
            instance = new ProductValidator();
        }

        return instance;
    }

    public boolean isValidate(Product product) throws ProductNameEmptyException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductPriceNoPositiveException {

        if(isProductNameEmpty(product.getProductName())) {
            throw new ProductNameEmptyException("Product name cannot be empty.");
        }

        if(isProductCountNegative(product.getProductCount())) {
            throw new ProductCountNegativeException("Product count is less than 0.");
        }

        if(isProductWeightNoPositive(product.getProductWeight())) {
            throw new ProductWeightNoPositiveException("Product weight is less or equals 0.");
        }

        if(isProductPriceNoPositive(product.getProductPrice())) {
            throw new ProductPriceNoPositiveException("Product Price is no positive");
        }

        return true;

    }


    private boolean isProductCountNegative(int productCount) {
        return productCount <= 0;
    }

    private boolean isProductWeightNoPositive(float weight) {
        return weight <= 0;
    }

    private boolean isProductPriceNoPositive(double price) {
        return price <= 0;
    }
    private boolean isProductNameEmpty(String productName) {
        return productName == null;
    }




}
