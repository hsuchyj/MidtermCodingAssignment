package com.cisc181.core;


import static org.junit.Assert.*;

import java.util.*;
import java.text.*;
import com.cisc181.*;

import com.cisc181.eNums.eMajor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

public class Student_Test {

	static ArrayList<Course> courses = new ArrayList<Course>();
	static ArrayList<Semester> semesters;
	static ArrayList<Section> sections;
	static ArrayList<Student> students;
	static ArrayList<Enrollment> enrollments;

	@BeforeClass
	public static void setup() throws PersonException, ParseException
	{
		UUID course1 = UUID.randomUUID();
		UUID course2 = UUID.randomUUID();
		UUID course3 = UUID.randomUUID();

		//courses = new ArrayList<Course>();

		Course a = new Course(course1,"CISC181", 40);
		Course b = new Course(course2,"CISC106", 40);
		Course c = new Course(course3,"CISC220", 40);

		courses.add(a);
		courses.add(b);
		courses.add(c);

		DateFormat d = new SimpleDateFormat("MM/dd/yyyy");
		Date fall1 = d.parse("08/30/2016");
		Date fall2 = d.parse("12/17/2016");
		Date spring1 = d.parse("02/06/2017");
		Date spring2 = d.parse("05/25/2017");

		UUID fallID = UUID.randomUUID();
		UUID springID = UUID.randomUUID();

		Semester fall = new Semester(fallID, new Date(), new Date());
		Semester spring = new Semester(springID, new Date(), new Date());

		semesters = new ArrayList<Semester>();

		semesters.add(fall);
		semesters.add(spring);

		sections = new ArrayList<Section>();

		Section a1 = new Section(course1,fallID, UUID.randomUUID(),101);
		Section a2 = new Section(course1,springID, UUID.randomUUID(),102);

		Section b1 = new Section(course2,fallID, UUID.randomUUID(),103);
		Section b2 = new Section(course2,springID, UUID.randomUUID(),104);

		Section c1 = new Section(course3,fallID, UUID.randomUUID(),105);
		Section c2 = new Section(course3,springID, UUID.randomUUID(),106);

		sections.add(a1);
		sections.add(a2);
		sections.add(b1);
		sections.add(b2);
		sections.add(c1);
		sections.add(c2);

		students = new ArrayList<Student>();

		for(int i = 0; i < 10;i++)
		{
			students.add(new Student("Bill", "Jacobs","Smith", new Date(), eMajor.PHYSICS, "address", "302-222-2222", "bill@email.com")
					);
		}

	}


	@Test
	public void testGPA() {

		enrollments = new ArrayList<Enrollment>();		

		for(int i= 0; i < students.size(); i++)
		{
			for(int j = 0; j < sections.size(); j++)
			{
				enrollments.add(new Enrollment((sections.get(j)).getSectionID(), students.get(i).getStudentID()));
			}
		}

		for(int i = 0; i < enrollments.size(); i++)
		{
			enrollments.get(i).setGrade(40+i);//grades from 40 to 99
		}

		ArrayList<Double> GPAS = new ArrayList<Double>();
		double gpa = 0;
		UUID stud;

		for(Student s: students)
		{
			stud = s.getStudentID();

			for(Enrollment e : enrollments)
			{
				if(e.getStudentID().equals(stud))
				{
					if(e.getGrade() > 95)
					{
						gpa = gpa + 4;
					}
					else if(e.getGrade() < 95 && e.getGrade() > 90)
					{
						gpa = gpa + 3.7;
					}
					else if(e.getGrade() < 90 && e.getGrade() > 87)
					{
						gpa = gpa + 3.3;
					}
					else if(e.getGrade() < 87 && e.getGrade() > 83)
					{
						gpa = gpa + 3;
					}
					else if(e.getGrade() < 83 && e.getGrade() > 80)
					{
						gpa = gpa + 2.7;
					}
					else if(e.getGrade() < 80 && e.getGrade() > 77)
					{
						gpa = gpa + 2.3;
					}
					else if(e.getGrade() < 77 && e.getGrade() > 73)
					{
						gpa = gpa + 2.0;
					}

					else if(e.getGrade() < 73 && e.getGrade() > 70)
					{
						gpa = gpa + 1.7;
					}
					else if(e.getGrade() < 70 && e.getGrade() > 67)
					{
						gpa = gpa + 1.3;
					}
					else if(e.getGrade() < 67 && e.getGrade() > 63)
					{
						gpa = gpa + 1.0;
					}
					else if(e.getGrade() < 63)
					{
						gpa = gpa + 0;
					}
				}
			}

			gpa = gpa / sections.size();
			GPAS.add(gpa);
			//

		}
		
		assertEquals(GPAS.get(9), 3.8374142661179698, 0);
	
	}
	
	@Test
	public void testAvg()
	{
		enrollments = new ArrayList<Enrollment>();
		
		for(int i= 0; i < students.size(); i++)
		{
			for(int j = 0; j < sections.size(); j++)
			{
				enrollments.add(new Enrollment((sections.get(j)).getSectionID(), students.get(i).getStudentID()));
			}
		}

		for(int i = 0; i < enrollments.size(); i++)
		{
			enrollments.get(i).setGrade(40+i);//grades from 40 to 99

		}

		double tot = 0;
		ArrayList<Double> averages = new ArrayList<Double>();
		for(Section s : sections)
		{
			tot = 0;
			
			for(Enrollment e : enrollments)
			{
				if(e.getSectionID().equals(s.getSectionID()))
				{
					tot = tot + e.getGrade();
				}
			}
			averages.add((tot/10));
		}
		assertEquals(averages.get(5), 72.0, 0);
		
	}
	
	@Test
	public void testMajor()
	{
		Student a = students.get(0);
		a.setMajor(eMajor.NURSING);
		assertEquals(a.getMajor(), eMajor.NURSING);
		
	}
}