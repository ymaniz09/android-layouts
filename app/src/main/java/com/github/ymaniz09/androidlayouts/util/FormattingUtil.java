package com.github.ymaniz09.androidlayouts.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormattingUtil {
    public static String formatBigDecimalToUSCurrency(BigDecimal value) {
        NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance(
                new Locale("en", "US"));

        return currencyInstance.format(value).replace("$", "$ ");
    }
}
