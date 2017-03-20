package com.cisc181.core;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	
	//private eMajor Major;
	
	//constructor
	public Course(UUID courseID, String courseName, int gradePoints) {
		CourseID = courseID;
		CourseName = courseName;
		GradePoints = gradePoints;
	}
	
	/*public Course(UUID semesterID, String courseName, int gradePoints, eMajor major) {
		SemesterID = semesterID;
		CourseName = courseName;
		GradePoints = gradePoints;
		Major = major;
	}
*/


	//setters and getters
	
	public void setCourseName(String c)
	{
		this.CourseName = c;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public String getCourseName()
	{
		return CourseName;
	}
	
	public void setGradePoints(int g)
	{
		this.GradePoints = g;
	}
	
	public int getGradePoints()
	{
		return GradePoints;
	}


	
	
	
	
	
	
	

}
