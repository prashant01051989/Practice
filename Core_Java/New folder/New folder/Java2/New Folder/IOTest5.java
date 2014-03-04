import java.io.*;

class IOTest5{
public static void main(String as[]){
try{
char ch[]={'P','R','A','S','H','A','N','T','*'};
CharArrayReader car=new CharArrayReader(ch);
CharArrayWriter caw=new CharArrayWriter();
char c ;
do{
int b=car.read();
c=(char)b;
if(c!='*'){
caw.write(b);
System.out.println(c);
}
}while(c!='*');
System.out.println(caw);

}catch(Exception e){
e.printStackTrace();
}

}
}