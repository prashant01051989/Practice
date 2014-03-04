package com.om.number;

import java.text.FieldPosition;
import java.text.NumberFormat;

public class Number2 {
	public static void main(String[] args)
    {
        
        NumberFormat numForm = NumberFormat.getInstance();

        StringBuffer dest1 = new StringBuffer(24);
        StringBuffer dest2 = new StringBuffer(24);
        FieldPosition pos = new FieldPosition(NumberFormat.FRACTION_FIELD);

        dest1 = numForm.format(22.34226666666, dest1, pos);
        System.out.println("dest1 = " + dest1);
        System.out.println("FRACTION is at: " + pos.getBeginIndex() +
            ", " + pos.getEndIndex());

        dest2 = numForm.format(64000D, dest2, pos);
        System.out.println("dest2 = " + dest2);
        System.out.println("FRACTION is at: " + pos.getBeginIndex() +
            ", " + pos.getEndIndex());
    }
}
