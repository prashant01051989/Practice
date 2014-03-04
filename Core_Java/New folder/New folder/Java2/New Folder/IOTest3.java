import java.io.*;

class IOTest3{
public static void main(String as[]){
FileWriter fw=null;
try{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
fw=new FileWriter("om.txt",true);
String st=br.readLine();
fw.write(st);
FileReader fr=new FileReader("om.txt"); 
int ch;
while((ch=fr.read())!=-1){

System.out.print((char)ch);
}
}catch(Exception e){
e.printStackTrace();

}finally{
try{
fw.close();
}catch(Exception e){
e.printStackTrace();

}

}
}
}