import java.io.*;
class Lab1{
	public static void main(String as[]){
	
		InputStreamReader isr=new InputStreamReader(System.in);
		try{
			char ch=(char)isr.read();
			/*unreported exception java.io.IOException; must be 
			caught or declared to be thrown	char ch=(char)isr.read();*/
			System.out.println("You entered this chracter: " +ch);
		}	catch(Exception e){
				e.printStackTrace();
			}
	}
}