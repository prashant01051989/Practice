import java.io.*;
class Lab3{
	public static void main(String as[]){
	
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		try{
			System.out.println("Enter your phone number");	
			String st=br.readLine();
			long num=Long.parseLong(st);
			System.out.println("Enter your phone number: " +num);			
		}	catch(Exception e){
				e.printStackTrace();
			}
	}
}