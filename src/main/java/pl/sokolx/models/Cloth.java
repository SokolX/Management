package pl.sokolx.models;

import pl.sokolx.models.enums.Color;
import pl.sokolx.models.enums.Material;
import pl.sokolx.models.enums.ProductSeparators;

public class Cloth extends Product {

    private String clothSize;
    private Material material;

    public Cloth(Long productId, String productName, double productPrice, float productWeight, Color productColor, int productCount, String clothSize, Material material) {
        super(productId, productName, productPrice, productWeight, productColor, productCount);
        this.clothSize = clothSize;
        this.material = material;
    }

    public String getClothSize() {
        return clothSize;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID
                + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString()
                + clothSize+ ProductSeparators.PRODUCT_SEPARATOR.toString() + material;
    }
}
