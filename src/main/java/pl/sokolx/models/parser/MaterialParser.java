package pl.sokolx.models.parser;

import pl.sokolx.models.enums.Material;

public class MaterialParser {

    public static Material parseStrToMaterial(String str) {
        String material = str.toUpperCase();

        return switch (material) {
            case "LEATHER" -> Material.LEATHER;
            case "FUR" -> Material.FUR;
            case "COTTON" -> Material.COTTON;
            case "WOOL" -> Material.WOOL;
            case "JEANS" -> Material.JEANS;
            default -> Material.POLYESTERS;
        };

    }
}
