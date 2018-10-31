package pl.sokolx.models;

import pl.sokolx.models.enums.Color;
import pl.sokolx.models.enums.ProductSeparators;

public class Product {

    private Long productId;
    private String productName;
    private double productPrice;
    private float productWeight;
    private Color productColor;
    private int productCount;

    public Product(Long productId, String productName, double productPrice, float productWeight, Color productColor,
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

    public Color getProductColor() {
        return productColor;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    protected String getBasicProductString() {
        return productId + ProductSeparators.PRODUCT_SEPARATOR.toString() + productName + ProductSeparators.PRODUCT_SEPARATOR.toString() + productPrice + ProductSeparators.PRODUCT_SEPARATOR.toString() + productWeight + ProductSeparators.PRODUCT_SEPARATOR.toString() + productColor + ProductSeparators.PRODUCT_SEPARATOR.toString() + productCount;
    }

    @Override
    public String toString() {
        return ProductSeparators.PRODUCT_ID
                + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString();
    }
}
