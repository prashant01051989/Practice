package com.jdbc;
import java.sql.*;
class InsufficientFundsException extends Exception
{
	
	InsufficientFundsException(){}
	public String toString()
	{
		return "Sufficient Funds are Not Available";
	}
}