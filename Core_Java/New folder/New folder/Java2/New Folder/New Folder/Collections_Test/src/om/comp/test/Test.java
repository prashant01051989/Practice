package om.comp.test;

public class Test {
	public static void main(String[] args)
    {
        try
        {
            // Create two new TestScore objects.
        	Hello bob = new Hello("John Smith", 84);
        	Hello mary = new Hello("Katie Jordan", 91);

            // Determine how bob compares to mary.
            int comparison = bob.compareTo(mary);

            // Print out the results of the comparison.
            System.out.print("John's test score was ");

            if (comparison == -1)
                System.out.print("less than ");
            else if (comparison == 0)
                System.out.print("equal to ");
            else
                System.out.print("greater than ");

            System.out.println("Katie's test score.");
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ex.toString());
        }
}
}