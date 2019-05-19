
/**
 * UserManagementWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package UserManagement;

import es.upm.fi.sos.t3.usermanagement.*;
import es.upm.fi.sos.t3.usermanagement.xsd.*;

/**
 *  UserManagementWSSkeleton java skeleton for the axisService
 */
public class UserManagementWSSkeleton{


	/**
	 * Auto generated method signature
	 * 
	 * @param changePassword 
	 * @return changePasswordResponse 
	 */
	public ChangePasswordResponse changePassword (ChangePassword changePassword)	{
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + 
		this.getClass().getName() + "#changePassword");
	}


	/**
	 * Starts new session for user in login
	 * 
	 * @param login 			user info
	 * @return loginResponse 	"true" if success (Pwd corresponds to Name)
	 */
	public LoginResponse login (Login login) {
		//TODO : fill this with the necessary business logic
		LoginResponse result = new LoginResponse();
		Response response = new Response();
		
		if(login.equals(null) || 
				!login.getArgs0().isNameSpecified() || 
				!login.getArgs0().isPwdSpecified()) {
			response.setResponse(false);
		}else {
		String userName = login.getArgs0().getName();
		String userPwd = login.getArgs0().getPwd();
		
		
		
		response.setResponse(true);
		}
		result.set_return(response);
		return result;
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param logout 
	 * @return  
	 */
	public void logout (Logout logout) {
		//TODO : fill this with the necessary business logic

	}


	/**
	 * Auto generated method signature
	 * 
	 * @param showCourses 
	 * @return showCoursesResponse 
	 */
	public ShowCoursesResponse showCourses (ShowCourses showCourses) {
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + 
		this.getClass().getName() + "#showCourses");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param showAllGrades 
	 * @return showAllGradesResponse 
	 */
	public ShowAllGradesResponse showAllGrades (ShowAllGrades showAllGrades) {
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + 
		this.getClass().getName() + "#showAllGrades");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param addUser 
	 * @return addUserResponse 
	 */
	public AddUserResponse addUser (AddUser addUser) {
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + 
		this.getClass().getName() + "#addUser");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param removeUser 
	 * @return removeUserResponse 
	 */
	public RemoveUserResponse removeUser (RemoveUser removeUser) {
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + 
		this.getClass().getName() + "#removeUser");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param addCourseGrade 
	 * @return addCourseGradeResponse 
	 */
	public AddCourseGradeResponse addCourseGrade (AddCourseGrade addCourseGrade) {
		//TODO : fill this with the necessary business logic
		throw new  java.lang.UnsupportedOperationException("Please implement " + 
		this.getClass().getName() + "#addCourseGrade");
	}

}
