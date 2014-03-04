package om.jdbc.test;

public class InsufficientFundsException extends Exception {
public String toString(){
	return "Sufficent Funds are not Available";
}
}
