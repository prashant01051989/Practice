package com.om.number;

import java.text.NumberFormat;

public class Number1 {
	public static void main(String[] args)
    {
        
        NumberFormat numForm = NumberFormat.getInstance();

        String dest1 = numForm.format(22.3423D);
        System.out.println("dest1 = " + dest1);
        String dest2 = numForm.format(64000D);
        System.out.println("dest2 = " + dest2);
    }
}
