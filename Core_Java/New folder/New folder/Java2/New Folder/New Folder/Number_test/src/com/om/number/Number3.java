package com.om.number;

import java.text.FieldPosition;
import java.text.NumberFormat;

public class Number3 {
	public static void main(String[] args)
    {
        
        NumberFormat numForm = NumberFormat.getInstance();
        numForm.setMaximumFractionDigits(5);
        StringBuffer dest1 = new StringBuffer(24);
        FieldPosition pos = new FieldPosition(NumberFormat.FRACTION_FIELD);

        dest1 = numForm.format(22.34226666666, dest1, pos);
        System.out.println("dest1 = " + dest1);
        System.out.println("FRACTION is at: " + pos.getBeginIndex() +
            ", " + pos.getEndIndex());

        System.out.println("Maximum Fraction Digits: " +
                numForm.getMaximumFractionDigits());
            System.out.println("Maximum Integer Digits: " +
                numForm.getMaximumIntegerDigits());
            System.out.println("Minimum Fraction Digits: " +
                numForm.getMinimumFractionDigits());
            System.out.println("Minimum Integer Digits: " +
                numForm.getMinimumIntegerDigits());
            System.out.println("Is Grouping Used? " +
                numForm.isGroupingUsed());
            System.out.println("Is Parse Integer Only? " +
                numForm.isParseIntegerOnly());
    }
}
