package om.comp.test;

 class Student implements Comparable{
	
int sid;
String sname;
String email;

public Student() {
	super();
}

public Student(int sid, String sname, String email) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.email = email;
}

public String toString(){
	return ""+sid+"\t"+sname+"\t"+email;
}
public boolean equals(Object o){
	System.out.println("equals(Object o)");
	Student s=(Student)o;
	if(this.sid==s.sid)
		return true;
	return false;
}

public int compareTo(Object obj)
{
	System.out.println("CompareTO()");
	Student s=(Student) obj;
	//return this.sid-s.sid;
	//return this.email.compareTo(s.email);
	return this.sname.compareTo(s.sname);
}

}
