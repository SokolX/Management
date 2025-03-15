package pl.sokolx.models;

import pl.sokolx.models.enums.Color;
import pl.sokolx.models.enums.ProductSeparators;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private final Long productId;
    private final String productName;
    private final BigDecimal productPrice;
    private final float productWeight;
    private final Color productColor;
    private final int productCount;

    public Product(Long productId,
                   String productName,
                   BigDecimal productPrice,
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

    public BigDecimal getProductPrice() {
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;
        return Float.compare(product.productWeight, productWeight) == 0 &&
                productCount == product.productCount &&
                Objects.equals(productId, product.productId) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productPrice, product.productPrice) &&
                Objects.equals(productColor, product.productColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productPrice, productWeight, productColor, productCount);
    }

    @Override
    public String toString() {
        return ProductSeparators.PRODUCT_ID
                + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString();
    }
}
