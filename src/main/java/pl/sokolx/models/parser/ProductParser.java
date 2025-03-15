package pl.sokolx.models.parser;

import pl.sokolx.models.Boots;
import pl.sokolx.models.Cloth;
import pl.sokolx.models.Product;
import pl.sokolx.models.enums.Material;
import pl.sokolx.models.enums.ProductSeparators;
import pl.sokolx.models.enums.SkinType;
import pl.sokolx.models.enums.Color;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductParser {

    public static Product stringToProduct(String productStr) {
        final ProductSeparators productType = ProductSeparators.getIdByChar(productStr.substring(0,1));

        switch (productType) {
            case PRODUCT_ID:
                return convertToProduct(getSplitedProductInformations(productStr));
            case ClOTH_ID:
                return convertToCloth(getSplitedProductInformations(productStr));
            case BOOTS_ID:
                return convertToBoots(getSplitedProductInformations(productStr));
        }
        return null;
    }

    private static Boots convertToBoots(String[] productInformations) {
        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = convertStringToBigDecimal(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);
        Integer size = Integer.parseInt(productInformations[7]);
        SkinType skinType = SkinParser.parseStrToSkinType(productInformations[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, skinType);
    }

    private static Cloth convertToCloth(String[] productInformations) {
        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = convertStringToBigDecimal(productInformations[3]);
        float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        int productCount = Integer.parseInt(productInformations[6]);
        String size = productInformations[7];
        Material material = MaterialParser.parseStrToMaterial(productInformations[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    private static Product convertToProduct(String[] productInformations) {
        Long id = Long.parseLong(productInformations[1]);
        String productName = productInformations[2];
        BigDecimal price = convertStringToBigDecimal(productInformations[3]);
        Float weight = Float.parseFloat(productInformations[4]);
        Color color = ColorParser.parseStrToColor(productInformations[5]);
        Integer productCount = Integer.parseInt(productInformations[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    private static String[] getSplitedProductInformations(String productStr) {
        return productStr.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
    }

    private static BigDecimal convertStringToBigDecimal(String productInformations) {
        return BigDecimal.valueOf(Float.parseFloat(productInformations)).setScale(2, RoundingMode.HALF_EVEN);
    }
}
