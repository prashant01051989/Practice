import java.io.*;

class IOTest6{
public static void main(String as[]){
try{
FileReader fr=new FileReader("a.doc");
FileWriter fw=new FileWriter("Anshu.txt");
int i;
while((i=fr.read())!=-1){
fw.write((char)i);
}
fr.close();
fw.close();
}catch(Exception e){
e.printStackTrace();
}

}
}