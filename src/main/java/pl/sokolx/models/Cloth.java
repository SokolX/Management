package pl.sokolx.models;

public class Cloth extends Product {

    private String clothSize;
    private String clothMaterial;

    public Cloth(Long productId, String productName, double productPrice, float productWeight, String productColor, int productCount, String clothSize, String clothMaterial) {
        super(productId, productName, productPrice, productWeight, productColor, productCount);
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
        return super.toString() + ", Cloth{" +
                "clothSize='" + clothSize + '\'' +
                ", clothMaterial='" + clothMaterial + '\'' +
                '}';
    }
}
