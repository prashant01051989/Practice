class Lab4{
public static void main(String as[]){
System.out.println("BEGINING");
try{
System.out.println("St1");
//throw new ArrayIndexOutOfBoundsException();
	try{
	System.out.println("St2");
	//throw new ArrayIndexOutOfBoundsException();
	}catch(Exception e){
	System.out.println("St3");
	throw new ArrayIndexOutOfBoundsException();
	}finally{
	System.out.println("St4");
	//throw new ArrayIndexOutOfBoundsException();
	}
System.out.println("St5");
throw new ArrayIndexOutOfBoundsException();	
}catch(Exception e1){
		System.out.println("St6");
		throw new ArrayIndexOutOfBoundsException();
		/*try{
			System.out.println("St7");
		//throw new ArrayIndexOutOfBoundsException();
		}
		catch(Exception e3){
			System.out.println("St8");
			//throw new ArrayIndexOutOfBoundsException();
		}finally{
			System.out.println("St9");
			//throw new ArrayIndexOutOfBoundsException();
		}*/
	//System.out.println("St10");
	//throw new ArrayIndexOutOfBoundsException();	
	}
finally{

	System.out.println("St11");
	//throw new ArrayIndexOutOfBoundsException();
	try{
		System.out.println("St12");
		//throw new ArrayIndexOutOfBoundsException();
	}catch(Exception e4){
		System.out.println("St13");
		//throw new ArrayIndexOutOfBoundsException();
	}finally{
		System.out.println("St14");
		//throw new ArrayIndexOutOfBoundsException();
	}
System.out.println("St15");
//throw new ArrayIndexOutOfBoundsException();	
	
}
//System.out.println("END");
}
}