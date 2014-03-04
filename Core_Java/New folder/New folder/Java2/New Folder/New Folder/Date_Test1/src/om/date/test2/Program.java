package om.date.test2;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program
{
	 public static void main(String[] args)
	    {
	       
	        String pattern = "''dd'-'MMM'-'yyyy''";
	        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

	        // Print out the time now using the format method.
	        StringBuffer buf = new StringBuffer();
	        FieldPosition pos = new FieldPosition(DateFormat.YEAR_FIELD);
	        sdf.format(new Date(), buf, pos);
	        System.out.println(buf);
	        System.out.println("The year field occupies indices: " +
	            pos.getBeginIndex() + " - " + pos.getEndIndex());
	    }
}