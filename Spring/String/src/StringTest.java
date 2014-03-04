import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StringTest {

	public static void main(String[] args) {
		List<String> l=new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			l.add(""+i);
		}
		long current=System.currentTimeMillis();
		current=current/1000*60*60;
		System.out.println(l);
		Set<String>set=new HashSet<String>();
		for (int i = 0; i < 100; i++) {
			set.add(""+i);
		}
		System.out.println(set.size());
		
		l.contains("100");
		long after=System.currentTimeMillis();
		System.out.println(after);
		System.out.println(current);
	}
	
		

}
