package pl.sokolx.models;

import pl.sokolx.models.enums.Color;
import pl.sokolx.models.enums.ProductSeparators;

public class Product {

    private final Long productId;
    private final String productName;
    private final double productPrice;
    private final float productWeight;
    private final Color productColor;
    private final int productCount;

    public Product(Long productId,
                   String productName,
                   double productPrice,
                   float productWeight,
                   Color productColor,
                   int productCount) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
        this.productColor = productColor;
        this.productCount = productCount;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public float getProductWeight() {
        return productWeight;
    }

    public int getProductCount() {
        return productCount;
    }

    protected String getBasicProductString() {
        return productId + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + productName + ProductSeparators.PRODUCT_SEPARATOR
                + productPrice + ProductSeparators.PRODUCT_SEPARATOR
                + productWeight + ProductSeparators.PRODUCT_SEPARATOR
                + productColor + ProductSeparators.PRODUCT_SEPARATOR
                + productCount;
    }

    @Override
    public String toString() {
        return ProductSeparators.PRODUCT_ID
                + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString();
    }
}
