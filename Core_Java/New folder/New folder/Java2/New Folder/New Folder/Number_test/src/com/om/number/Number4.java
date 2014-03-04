package com.om.number;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;



public class Number4 {
	public static void main(String[] args)
    {
        // Create a new DecimalFormat object.
        DecimalFormat decForm = new DecimalFormat();

        // Display the various properties of the
        // DecimalFormatSymbols object.
        DecimalFormatSymbols dfs =
            decForm.getDecimalFormatSymbols();

        System.out.println("DecimalFormatSymbols.getDecimalSeparator: " +
            dfs.getDecimalSeparator());
        System.out.println("DecimalFormatSymbols.getDigit: " +
            dfs.getDigit());
        System.out.println("DecimalFormatSymbols.getGroupingSeparator: " +
            dfs.getGroupingSeparator());
        System.out.println("DecimalFormatSymbols.getInfinity: " +
            dfs.getInfinity());
        System.out.println("DecimalFormatSymbols.getMinusSign: " +
            dfs.getMinusSign());
        System.out.println("DecimalFormatSymbols.getNaN: " +
            dfs.getNaN());
        System.out.println("DecimalFormatSymbols.getPatternSeparator: " +
            dfs.getPatternSeparator());
        System.out.println("DecimalFormatSymbols.getPercent: " +
            dfs.getPercent());
        System.out.println("DecimalFormatSymbols.getPerMill: " +
            dfs.getPerMill());
        System.out.println("DecimalFormatSymbols.getZeroDigit: " +
            dfs.getZeroDigit());
    }
}
