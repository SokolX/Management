package pl.sokolx.models;

public class Cloth extends Product {

    private String clothSize;
    private String clothMaterial;
    private ProductType productType;


    public Cloth(Long productId, String productName, double productPrice, float productWeight, String productColor, int productCount, ProductType productType, String clothSize, String clothMaterial) {
        super(productId, productName, productPrice, productWeight, productColor, productCount, productType);
        this.productType = ProductType.CLOTH;
        this.clothSize = clothSize;
        this.clothMaterial = clothMaterial;
    }

    public String getClothSize() {
        return clothSize;
    }

    public String getClothMaterial() {
        return clothMaterial;
    }

    @Override
    public String toString() {
        return super.toString() + "," + productType + "," + clothSize + "," + clothMaterial;
    }
}
