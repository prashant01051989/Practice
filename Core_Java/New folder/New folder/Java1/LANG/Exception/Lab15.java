class InvalidIdException extends Exception{
int id;
InvalidIdException(){}
InvalidIdException(int id){
this.id=id;
}
public String getMessage(){
String msg=null;
msg="Id No:"+id+"is not Valid.";
return msg;
}
public String toString(){
return"InvalidIdException: "+getMessage();
}
}
class detail{
int getId(int id){
try{
if(id>100){
throw new InvalidIdException(id);
}
else{
return id;
}
}catch(Exception e){
System.out.println(e);
System.out.println(e.getMessage());
return id;
}
}
}

class Lab9{
public static void main(String as[]){
try{
int id=Integer.parseInt(as[0]);
detail de=new detail();
System.out.println(de.getId(id));
}catch(Exception e){
System.out.println(e);
System.out.println(e.getMessage());
}
}
}
