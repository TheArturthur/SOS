
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
	 * Checks if the subject in checkCourse exists in the system
	 * 
	 * @param checkCourse 			contains a String name with the name of the subject
	 * @return checkCourseResponse 	true if the subject exists
	 * 								false otherwise
	 */

	public CheckCourseResponse checkCourse (CheckCourse checkCourse) {
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#checkCourse");
	}


	/**
	 * Shows a list of the subjects related in the system with the course
	 * 
	 * @param showCourses 			contains the course from which the subjects shall be obtained
	 * 								the course is between 1 and 4
	 * 
	 * @return showCoursesResponse	the list of subjects related to the course
	 * 								may be empty if subjects or course don't exist	
	 */

	public ShowCoursesResponse showCourses (ShowCourses showCourses) {
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#showCourses");
	}

}
