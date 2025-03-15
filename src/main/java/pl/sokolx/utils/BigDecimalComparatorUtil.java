package pl.sokolx.utils;

import java.math.BigDecimal;

public class BigDecimalComparatorUtil {

    public static boolean isLessOrEqualThen(BigDecimal valueCompare, BigDecimal valueCompareTo) {
        return valueCompare.compareTo(valueCompareTo) <= 0;
    }
}
