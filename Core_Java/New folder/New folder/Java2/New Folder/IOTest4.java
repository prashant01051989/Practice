import java.io.*;

class IOTest4{
public static void main(String as[]){
try{
System.out.println("FIle.pathSeparator\t -: "+File.pathSeparator);
System.out.println("FIle.pathSeparatorChar\t -: "+File.pathSeparatorChar);
System.out.println("FIle.separator\t -: "+File.separator);
System.out.println("FIle.separatorChar\t -: "+File.separatorChar);
/*
File[] far=File.listRoots();
System.out.println(far.length);
for(int i=0;i<far.length;i++){
System.out.println(far[i].getName()+"\t"+far[i].isDirectory()+"\t"+far[i].isFile()+"\t"+far[i].isAbsolute()+"\t"+far[i].getPath()+"\t"+far[i].getAbsolutePath());
*/
File f1=new File("c:\\","Anshu.txt");
f1.createNewFile();

File f2=new File("Pra");
f2.mkdir();

File f3=new File(f2,"om\\io");
f3.mkdirs();

File f4=new File(f3,"san.txt");

System.out.println("f4.createNewFile() -: "+f4.createNewFile());
System.out.println("f4.getName() -: "+f4.getName());
System.out.println("f4.isFile() -: "+f4.isFile());
System.out.println("f4.length() -: "+f4.length());
System.out.println("f4.isHidden() -: "+f4.isHidden());
System.out.println("f4.getPath() -: "+f4.getPath());
System.out.println("f4.getCanonicalPath() -: "+f4.getCanonicalPath());
System.out.println("f4.getAbsolutePath() -: "+f4.getAbsolutePath());
System.out.println("f4.exists() -: "+f4.exists());
System.out.println("f4.getParent() -: "+f4.getParent());
System.out.println("f4.canRead() -: "+f4.canRead());
System.out.println("f4.canWrite() -: "+f4.canWrite());

f4.setReadOnly();
System.out.println("f4.canRead() -: "+f4.canRead());
System.out.println("f4.canWrite() -: "+f4.canWrite());

File f5=new File("Hello.txt");
System.out.println("f5.createNewFile() -: "+f5.createNewFile());
System.out.println("f5.getPath() -: "+f5.getPath());
System.out.println("f5.getCanonicalPath() -: "+f5.getCanonicalPath());
System.out.println("f5.getAbsolutePath() -: "+f5.getAbsolutePath());
System.out.println("f5.getParent() -: "+f5.getParent());

File f6=new File(f3,"Hello1.txt");
System.out.println("f6.createNewFile() -: "+f6.createNewFile());

File f7=new File(f3,"Hello2.txt");
System.out.println("f7.createNewFile() -: "+f7.createNewFile());

File f8=new File(f3,"Hello3.txt");
System.out.println("f8.createNewFile() -: "+f8.createNewFile());

File f9=new File(f3,"Hello4.txt");
System.out.println("f9.createNewFile() -: "+f9.createNewFile());

File f10=new File(f3,"Hello5.txt");
System.out.println("f10.createNewFile() -: "+f10.createNewFile());

String fnl[]=f3.list();
for(int i=0;i<fnl.length;i++){
System.out.print(fnl[i]+",");
}
}catch(Exception e){
e.printStackTrace();
}
}
}