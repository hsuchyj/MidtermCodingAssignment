package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void testSal() throws PersonException {
		ArrayList<Staff> list = new ArrayList<Staff>();
		
		double sal = 60000;
		for (int i = 0; i < 5; i++)
		{
			list.add(new Staff("karen", "karen", "karen",
					new Date(), "karen", "100-100-9000", "karen",
					"hi", 1, sal, new Date(),
				eTitle.MS));
			sal = sal + 10000;
		}
		
		double sum = 0;
		
		for(Staff a : list)
		{
			sum = sum + a.getSalary();
		}
		
		double avg = sum / 5;
		
		assertEquals(avg,80000, 0);
	}	
	
	@Test(expected = PersonException.class)
	public void testPhoneExcept() throws PersonException {
		Staff a = new Staff("karen", "karen", "karen",
				new Date(), "karen", "10-10-900", "karen",
				"hi", 1, 70, new Date(),
			eTitle.MS);
	}
	
	@Test(expected = PersonException.class)
	public void testDOBExcept() throws PersonException {
		Date d = new Date();
		d.setYear(218);//sets date to 2118
		
		Staff a = new Staff("karen", "karen", "karen",
				d, "karen", "100-100-9000", "karen",
				"hi", 1, 70, new Date(),
			eTitle.MS);
	}

}
