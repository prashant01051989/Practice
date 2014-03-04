import java.io.*;
class Lab2{
	public static void main(String as[]){
	
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		try{
			String name=br.readLine();
			System.out.println("You name is: " +name);			
		}	catch(Exception e){
				e.printStackTrace();
			}
	}
}