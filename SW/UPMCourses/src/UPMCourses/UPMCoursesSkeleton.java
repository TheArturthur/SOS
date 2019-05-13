
/**
 * UPMCoursesSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package UPMCourses;

import es.upm.fi.sos.t3.practica.*;
/**
 *  UPMCoursesSkeleton java skeleton for the axisService
 */
public class UPMCoursesSkeleton{


	/**
	 * Checks if the course in CheckCourse object exists.
	 * 
	 * @param checkCourse			checkCourse has String argument called name that specifies
	 * 								the course name
	 * @return checkCourseResponse	true: if checkCourse's course name is one of the existing 
	 * 								courses
	 * 								
	 * 								false: otherwise
	 */

	public CheckCourseResponse checkCourse (CheckCourse checkCourse) {
		//TODO : fill this with the necessary business logic
		CheckCourseResponse result = new CheckCourseResponse();
		
		if (checkCourse.getArgs0() != null){ //Shall it be checking with the existing courses???
			result.set_return(true);
		} else {
			result.set_return(false);
		}
		
		return result;
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param showCourses 
	 * @return showCoursesResponse 
	 */

	public ShowCoursesResponse showCourses (ShowCourses showCourses) {
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#showCourses");
	}

}
