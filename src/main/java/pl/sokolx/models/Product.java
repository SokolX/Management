package pl.sokolx.models;

public class Product {

    private Long productId;
    private String productName;
    private double productPrice;
    private float productWeight;
    private String productColor;
    private int productCount;
    private ProductType productType;

    public Product(Long productId, String productName, double productPrice, float productWeight, String productColor,
                   int productCount, ProductType productType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
        this.productColor = productColor;
        this.productCount = productCount;
        this.productType = ProductType.PRODUCT;
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

    public String getProductColor() {
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

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return  productId +
                "," + productName +
                "," + productPrice +
                "," + productWeight +
                "," + productColor +
                "," + productCount +
                "," + productType;
    }
}
