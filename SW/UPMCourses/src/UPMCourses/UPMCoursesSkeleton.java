
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
		
		if(checkCourse.getArgs0() != null /*&& checkCourse.getArgs0().equals(subject_in_system)*/) {
			result.set_return(true);
		} else {
			result.set_return(false);
		}
		return result;
	}


	/**
	 * Gets the list of subjects of a certain course.
	 * 
	 * @param showCourses 			contains the course from which the subjects are wanted to be
	 * 								obtained (1 to 4)
	 * 								
	 * @return showCoursesResponse	the list of the existing subjects in the system for the course
	 * 								If there's no subject, shall return an empty list. 
	 */

	public ShowCoursesResponse showCourses (ShowCourses showCourses) {
		//TODO : fill this with the necessary business logic
		ShowCoursesResponse subjects = new ShowCoursesResponse();
		int course = showCourses.getArgs0();
		if (showCourses.isArgs0Specified() && course > 0 && course < 5) { 
		// If the course is specified and between 1 and 4
			// TODO: fill subjects with the system subjects of course
			
		}
		
		return subjects;
	}

}
