package om.comp.test;

 class Hello implements Comparable{
	
	 private String studentName;
	 private int score;

	 public Hello(String nameOfStudent,
             int testScore)
{
studentName = nameOfStudent;
score = testScore;
}

// Implements Comparable.compareTo
// Compares the test scores of the two objects.
public int compareTo(Object obj)
{
if (obj instanceof Hello)
{
   Hello objTestScores = (Hello)obj;
   if (score < objTestScores.score)
       return -1;
   else if (score > objTestScores.score)
       return 1;
   else
       return 0;
}
else
{
   throw new IllegalArgumentException("obj must be an " +
       " instance of a TestScores object.");
}
}


}
