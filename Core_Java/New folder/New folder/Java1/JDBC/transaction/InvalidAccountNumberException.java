package com.jdbc;
import java.sql.*;
import com.jdbc.util.*;
class InvalidAccountNumberException extends Exception
{
	int accno;
	InvalidAccountNumberException(){}
	InvalidAccountNumberException(int accno)
	{
		this.accno=accno;
	}
	public String toString()
	{
		return "Accno:"+accno+" is NotFound";
	}
}