package om.jdbc.test;

public class InvalidAccountNumberException extends Exception {
int accno;
public InvalidAccountNumberException() {
}
InvalidAccountNumberException(int accno){
	this.accno=accno;
}
public String toString(){
	return "Accno: "+accno+" is Not Found";
}
}
