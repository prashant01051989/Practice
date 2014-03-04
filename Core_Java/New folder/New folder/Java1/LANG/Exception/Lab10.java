import java.sql.SQLException;
class Hai{
void m1() throws CloneNotSupportedException{
this.clone();
}
void m2(){
try{
throw new SQLException();
}catch(SQLException e){
e.printStackTrace();
}
}
void m3(){
throw new ArithmeticException();
}
}
public class Lab3{
public static void main(String as[]){
Hai h=new Hai();
try{
h.m1();
}catch(CloneNotSupportedException e){
e.printStackTrace();
}
}
}
