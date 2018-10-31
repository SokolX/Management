package pl.sokolx.models;

import pl.sokolx.models.enums.Color;
import pl.sokolx.models.enums.ProductSeparators;
import pl.sokolx.models.enums.SkinType;

public class Boots extends Product {

    private int bootsSize;
    private SkinType skinType;


    public Boots(Long productId, String productName, double productPrice, float productWeight, Color productColor, int productCount, int bootsSize, SkinType skinType) {
        super(productId, productName, productPrice, productWeight, productColor, productCount);
        this.bootsSize = bootsSize;
        this.skinType = skinType;

    }

    public int getBootsSize() {
        return bootsSize;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID
                + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + bootsSize + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + skinType;
    }
}
