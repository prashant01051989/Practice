import java.io.*;

class IOTest2{
public static void main(String as[]){
try{
InputStreamReader isr=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(isr);
FileWriter fw=new FileWriter("ANS.txt");

char c;
do{
c=(char)br.read();
fw.write(c);
}while(c!='\n');
fw.close();
}catch(Exception e){
e.printStackTrace();
}
}
}