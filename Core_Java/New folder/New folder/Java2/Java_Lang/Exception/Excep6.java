class InvalidAccNoException extends Exception{
int accno;
InvalidAccNoException(){}
InvalidAccNoException(int accno){
this.accno=accno;
}
public String getMessage(){
String msg=null;
if(accno==0){
msg="Acc No. is Not Available";
}
else{
msg="Account No. " +accno +" is Not Available";
}
return msg;
}
public String toString(){
return "InvalidAccNoException " +getMessage();
}
}
class InsufficientFundsException extends Exception{
int amt;
InsufficientFundsException(){}
InsufficientFundsException(int amt){
this.amt=amt;
}
public String getMessage(){
String msg=null;
if(amt>4000){
msg="Please withdraw less than "+amt;
}else{
msg="Sorry you dont have enough funds";
}
return msg;
}
public String toString(){
return "InsufficientFundsException: "+ getMessage();
}
}
class Account{
int bal=5000;
int getBal(int accno){
try{
if(accno>100){
throw new InvalidAccNoException(accno);
}
else 
return bal;
}catch(Exception e){
e.printStackTrace();
return bal;
}
}

void withdraw(int accno,int amt){
try{
if(accno>100){
throw new InvalidAccNoException();
}else{
if(amt+1000>bal){
throw new InsufficientFundsException(amt);
}else{
 bal=bal-amt;
}
}
}catch(Exception e){
e.printStackTrace();
}

}
}

class Excep6{
public static void main(String as[]){
try{
int accno=Integer.parseInt(as[0]);
int amt=Integer.parseInt(as[1]);
Account acc=new Account();
acc.getBal(accno);
acc.withdraw(accno, amt);
}catch(Exception e){
e.printStackTrace();
}
}
}