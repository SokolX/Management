package pl.sokolx.models.parser;


import pl.sokolx.models.enums.Color;

public class ColorParser {

    public static Color parseStrToColor(String str) {
        String color = str.toUpperCase();

        if (color.equals("RED")) {
            return Color.RED;
        } else if (color.equals("BLUE")) {
            return Color.BLUE;
        } else if (color.equals("BLACK")) {
            return Color.BLACK;
        } else if (color.equals("YELLOW")) {
            return Color.YELLOW;
        } else if (color.equals("GREEN")) {
            return Color.GREEN;
        } else if (color.equals("WHITE")) {
            return Color.WHITE;
        }

        return Color.WHITE;
    }
}
