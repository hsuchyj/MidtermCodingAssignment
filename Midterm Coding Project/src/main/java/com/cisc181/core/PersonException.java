package com.cisc181.core;
import java.util.*;

public class PersonException extends Exception{
	private Person p;
	
	public PersonException(Person p)
	{
		this.p = p;
		System.out.println("DOB or phone number was invalid");
		
	}
	

}
