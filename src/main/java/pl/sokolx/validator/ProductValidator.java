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

    public boolean isValidate(Product product) throws ProductNameEmptyException, ProductWeightNoPositiveException, ProductCountNegativeException, ProductPriceNoPositiveException {
        if (isPriceNoPositive(product.getProductPrice())) {
            throw new ProductPriceNoPositiveException("Product price is no positive.");
        }

        if (isCountNegative(product.getProductCount())) {
            throw new ProductCountNegativeException("Product count is less than 0.");
        }

        if (isWeightNoPositive(product.getProductWeight())) {
            throw new ProductWeightNoPositiveException("Product weight is less or equals 0.");
        }

        if (isNameEmpty(product.getProductName())) {
            throw new ProductNameEmptyException("Product name cannot be empty.");
        }

        return true;
    }

    private boolean isNameEmpty(String productName) {
        return productName.isEmpty();
    }

    private boolean isWeightNoPositive(Float weight) {
        return weight <= 0.0d;
    }

    private boolean isCountNegative(Integer productCount) {
        return productCount < 0;
    }

    private boolean isPriceNoPositive(Double price) {
        return price <= 0;
    }

}
