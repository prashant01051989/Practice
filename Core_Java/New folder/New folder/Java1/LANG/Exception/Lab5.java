class Lab5{
public static void main(String as[]){
System.out.println("BEGINING");
try{
System.out.println("St1");
	try{
	System.out.println("St2");
	}catch(Exception e){
	System.out.println("St3");
	}finally{
	System.out.println("St4");
	throw new ArrayIndexOutOfBoundsException();
	}
//System.out.println("St5");
}catch(Exception e1){
		System.out.println("St6");
		try{
			System.out.println("St7");
		}
		catch(Exception e3){
			System.out.println("St8");
		}finally{
			System.out.println("St9");
		}
	System.out.println("St10");
	}
finally{

	System.out.println("St11");
	
	try{
		System.out.println("St12");
	}catch(Exception e4){
		System.out.println("St13");
	}finally{
		System.out.println("St14");
	}
System.out.println("St15");

	
}
System.out.println("END");
}
}