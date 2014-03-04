import java.io.*;
class Lab5{
	public static void main(String as[]){
	
		DataInputStream dsr=new DataInputStream(System.in);
		//BufferedReader br=new BufferedReader(dsr);
		try{
			System.out.println("Enter your first number");	
			int a=Integer.parseInt(dsr.readLine());
			System.out.println("Enter your second number");			
			int b=Integer.parseInt(dsr.readLine());
			int sum=a+b;
			System.out.println("sum of two  number is: " +sum);			
		}	catch(Exception e){
				e.printStackTrace();
			}
	}
}