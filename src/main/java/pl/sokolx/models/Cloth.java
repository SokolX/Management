package pl.sokolx.models;

import pl.sokolx.models.enums.Color;
import pl.sokolx.models.enums.Material;
import pl.sokolx.models.enums.ProductSeparators;

import java.math.BigDecimal;

public class Cloth extends Product {

    private final String clothSize;
    private final Material material;

    public Cloth(Long productId,
                 String productName,
                 BigDecimal productPrice,
                 float productWeight,
                 Color productColor,
                 int productCount,
                 String clothSize,
                 Material material) {
        super(productId,
                productName,
                productPrice,
                productWeight,
                productColor,
                productCount);
        this.clothSize = clothSize;
        this.material = material;
    }

    @Override
    public String toString() {
        return ProductSeparators.BOOTS_ID + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + getBasicProductString() + ProductSeparators.PRODUCT_SEPARATOR
                + clothSize + ProductSeparators.PRODUCT_SEPARATOR
                + material;
    }
}
