package com.om.number;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;

public class Number5 {
	public static void main(String[] args)
    {
		/*
        // Create a new DecimalFormat object.
        DecimalFormat decForm = new DecimalFormat();

        // Display the various properties of the DecimalFormat
        // object.
        System.out.println("Negative Prefix: " +
            decForm.getNegativePrefix());
        */
		/*
     // Create a new DecimalFormat object.
        DecimalFormat decForm1 = new DecimalFormat();

        // Set the positive prefix to "" and the positive
        // suffix to "+".
        decForm1.setPositivePrefix("");
        decForm1.setPositiveSuffix("+");
        System.out.println("Positive Prefix: " +
            decForm1.getPositivePrefix());
        System.out.println("Positive Suffix: " +
            decForm1.getPositiveSuffix());
            */
		// Display the default localized pattern for a
        // DecimalFormat object.
        DecimalFormat decForm = new DecimalFormat();
        System.out.println("Default Pattern: " +
            decForm.toPattern());
    }
}
