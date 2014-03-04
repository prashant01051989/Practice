package om.comp.test;

import java.util.Comparator;

 class SnameComparator implements Comparator{
	
	public int compare(Object o1, Object o2) {
		 Thread t=new Thread();
		Student s1=(Student) o1;
		Student s2=(Student) o2;
		return s1.sname.compareTo(s2.sname);
		
	}

}
