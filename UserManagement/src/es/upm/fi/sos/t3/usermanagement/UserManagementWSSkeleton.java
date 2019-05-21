
/**
 * UserManagementWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package es.upm.fi.sos.t3.usermanagement;
/**
 *  UserManagementWSSkeleton java skeleton for the axisService
 */
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.axis2.AxisFault;

import es.upm.fi.sos.t3.usermanagement.xsd.*;
import es.upm.fi.sos.t3.upmcourses.*;

public class UserManagementWSSkeleton{

	private static HashMap <String,es.upm.fi.sos.t3.usermanagement.xsd.User> DB = new HashMap <String,es.upm.fi.sos.t3.usermanagement.xsd.User>();
	private static ArrayList <String> ConectedUsers = new ArrayList <String> ();
	private static HashMap <String, ArrayList <es.upm.fi.sos.t3.usermanagement.xsd.CourseGrade>> Asignaturas = new HashMap <String,  ArrayList <es.upm.fi.sos.t3.usermanagement.xsd.CourseGrade>>();
	
	private es.upm.fi.sos.t3.usermanagement.xsd.User userLogged;
	private boolean Logged;


	public UserManagementWSSkeleton(){
		if(DB.isEmpty()){

			User user = new User();
			user.setName("admin");
			user.setPwd("admin");

			DB.put("admin", user); 			
		}
		userLogged = null;
		this.Logged = false;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param changePassword 
	 * @return changePasswordResponse 
	 */

	public es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse changePassword
	(
			es.upm.fi.sos.t3.usermanagement.ChangePassword changePassword
			)
	{		es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse pwdResponse  = new es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse();
	Response response = new Response();
	response.setResponse(false);
	pwdResponse.set_return(response);
	if(Logged == true && userLogged != null){

		if (userLogged.getPwd().equals(changePassword.getArgs0().getOldpwd())){

			DB.get(userLogged.getName()).setPwd(changePassword.getArgs0().getNewpwd());
			userLogged = DB.get(userLogged.getName());
			pwdResponse.get_return().setResponse(true);

			return pwdResponse;

		}

	}
	return pwdResponse;      	 
	//TODO : fill this with the necessary business logic
	// throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#changePassword");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param login 
	 * @return loginResponse 
	 */

	public es.upm.fi.sos.t3.usermanagement.LoginResponse login
	(
			es.upm.fi.sos.t3.usermanagement.Login login
			)
	{
		es.upm.fi.sos.t3.usermanagement.LoginResponse LResponse = new es.upm.fi.sos.t3.usermanagement.LoginResponse();
		Response response = new Response();
		response.setResponse(false);
		LResponse.set_return(response);

		if(userLogged != null && login.getArgs0().getName().equals(login.getArgs0().getName()) && Logged){
			LResponse.get_return().setResponse(true);
			return LResponse;
		}
		User userDB = DB.get(login.getArgs0().getName());
		if(userDB == null){
			return LResponse;
		}

		if(!login.getArgs0().getPwd().equals(userDB.getPwd())){
			return LResponse;
		}

		if(!Logged){
			Logged = true;
			
			ConectedUsers.add(login.getArgs0().getName());
			userLogged = userDB;
			if(!Asignaturas.containsKey(userDB.getName())){
				Asignaturas.put(userDB.getName(), new ArrayList<es.upm.fi.sos.t3.usermanagement.xsd.CourseGrade>());
			}
			LResponse.get_return().setResponse(true);

		}
		return LResponse;
		//TODO : fill this with the necessary business logic
		//throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#login");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param logout 
	 * @return  
	 */

	public void logout
	(
			es.upm.fi.sos.t3.usermanagement.Logout logout
			)
	{

		if (ConectedUsers.contains(userLogged.getName())&&Logged && userLogged != null){
			ConectedUsers.remove(userLogged.getName());
			userLogged = null;
			Logged = false;
		}              	 
		//TODO : fill this with the necessary business logic             
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param showCourses 
	 * @return showCoursesResponse 
	 * @throws RemoteException 
	 */

	public es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse showCourses
	(
			es.upm.fi.sos.t3.usermanagement.ShowCourses showCourses
			) throws RemoteException
	{

		es.upm.fi.sos.t3.usermanagement.xsd.CourseResponse CR = new es.upm.fi.sos.t3.usermanagement.xsd.CourseResponse();
		CR.setResult(false);
		es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse showCoursesRes = new es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse();  
		showCoursesRes.set_return(CR);

		if(Logged && userLogged != null && DB.containsKey(userLogged.getName())){
			UPMCoursesStub UPMCourses = new UPMCoursesStub();
			UPMCourses._getServiceClient().getOptions().setManageSession(true);
			UPMCourses._getServiceClient().engageModule("addresing");
			UPMCoursesStub.ShowCourses SC = new UPMCoursesStub.ShowCourses();
			SC.setArgs0(showCourses.getArgs0().getCourse());
			UPMCoursesStub.ShowCoursesResponse SR = UPMCourses.showCourses(SC);

			CR.setResult(true);
			CR.setCourseList(SR.get_return());

			showCoursesRes.set_return(CR);
		}

		return showCoursesRes;


		//TODO : fill this with the necessary business logic
		//s throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#showCourses");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param showAllGrades 
	 * @return showAllGradesResponse 
	 */

	public es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse showAllGrades
	(
			es.upm.fi.sos.t3.usermanagement.ShowAllGrades showAllGrades
			)
	{
		es.upm.fi.sos.t3.usermanagement.xsd.GradesResponse GR = new es.upm.fi.sos.t3.usermanagement.xsd.GradesResponse();
		es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse shallgresponse = new es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse();
		GR.setResult(false);
		shallgresponse.set_return(GR);
		if (Logged && userLogged != null && DB.containsKey(userLogged.getName())){
			ArrayList<es.upm.fi.sos.t3.usermanagement.xsd.CourseGrade> coursegrade = Asignaturas.get(userLogged.getName());
			int c = coursegrade.size();
			String [] s = new String [c];
			double [] d = new double [c];
			double nota = 0;
			int index;
			
			for(int i = 0; c>=0; i++){
				index = 0;
				for (int j = 0; j < c; j++){
				if (nota<coursegrade.get(j).getGrade()){
					nota = coursegrade.get(j).getGrade();
					index = j;
				}
				}
				
				s[i]=coursegrade.get(index).getCourse();
				d[i]=coursegrade.get(index).getGrade();
				coursegrade.remove(index);
				c--;				
			}
			
			shallgresponse.get_return().setCourses(s);
			shallgresponse.get_return().setGrades(d);
			shallgresponse.get_return().setResult(true);
		}
		
		
		return shallgresponse;
		//TODO : fill this with the necessary business logic
	//	throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#showAllGrades");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param addUser 
	 * @return addUserResponse 
	 */

	public es.upm.fi.sos.t3.usermanagement.AddUserResponse addUser
	(
			es.upm.fi.sos.t3.usermanagement.AddUser addUser
			)
	{
		es.upm.fi.sos.t3.usermanagement.AddUserResponse UResponse = new es.upm.fi.sos.t3.usermanagement.AddUserResponse ();
		UResponse.get_return().setResponse(false);
		if (Logged && userLogged.getName().equals("admin") && !DB.containsKey(addUser.getArgs0().getName())){
			DB.put(addUser.getArgs0().getName(), addUser.getArgs0());
			UResponse.get_return().setResponse(true);
		}

		return UResponse;     	
		//TODO : fill this with the necessary business logic
		// throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addUser");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param removeUser 
	 * @return removeUserResponse 
	 */

	public es.upm.fi.sos.t3.usermanagement.RemoveUserResponse removeUser
	(
			es.upm.fi.sos.t3.usermanagement.RemoveUser removeUser
			)
	{
		es.upm.fi.sos.t3.usermanagement.RemoveUserResponse ruResponse = new es.upm.fi.sos.t3.usermanagement.RemoveUserResponse ();
		ruResponse.get_return().setResponse(false);

		if(Logged && DB.containsKey(removeUser.getArgs0().getUsername()) && userLogged.getName().equals(removeUser.getArgs0().getUsername()) && !userLogged.getName().equals("admin") && (ConectedUsers.indexOf(userLogged.getName())!=ConectedUsers.lastIndexOf(userLogged.getName()))){
			DB.remove(removeUser.getArgs0().getUsername());
			ruResponse.get_return().setResponse(true);
			Logged = false;
			return ruResponse;
		}
		if (Logged && DB.containsKey(removeUser.getArgs0().getUsername()) && userLogged.getName().equals("admin") && !userLogged.getName().equals(removeUser.getArgs0().getUsername())){
			DB.remove(removeUser.getArgs0().getUsername());
			ruResponse.get_return().setResponse(true);
			
			return ruResponse;
		}

		return ruResponse;
		//TODO : fill this with the necessary business logic
		//throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#removeUser");
	}


	/**
	 * Auto generated method signature
	 * 
	 * @param addCourseGrade 
	 * @return addCourseGradeResponse 
	 * @throws RemoteException 
	 */

	public es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse addCourseGrade
	(
			es.upm.fi.sos.t3.usermanagement.AddCourseGrade addCourseGrade
			) throws RemoteException
	{
		es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse CGResponse = new es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse() ;
		CGResponse.get_return().setResponse(false);
		if(Logged && userLogged != null && DB.containsKey(userLogged.getName())){
		String course = addCourseGrade.getArgs0().getCourse();
		UPMCoursesStub UPMCourses = new UPMCoursesStub();
		UPMCourses._getServiceClient().getOptions().setManageSession(true);
		UPMCourses._getServiceClient().engageModule("addresing");
		UPMCoursesStub.CheckCourse checkCourse = new UPMCoursesStub.CheckCourse ();
		checkCourse.setArgs0(course);
		UPMCoursesStub.CheckCourseResponse chcourseRes = UPMCourses.checkCourse(checkCourse);
		if (chcourseRes.get_return() == true){
			ArrayList<es.upm.fi.sos.t3.usermanagement.xsd.CourseGrade> coursegrade = Asignaturas.get(userLogged.getName());
			boolean bool = false;
			for(int i = 0; i<coursegrade.size() && !bool; i++){
				if(coursegrade.get(i).getCourse().equals(course)){
					coursegrade.get(i).setGrade(addCourseGrade.getArgs0().getGrade());
					bool = true;
				}
			}
			if(!bool){
				coursegrade.add(addCourseGrade.getArgs0());
				Asignaturas.put(userLogged.getName(), coursegrade);
			}
			CGResponse.get_return().setResponse(true);
		}
		}
		
		return CGResponse;
		//TODO : fill this with the necessary business logic
		//throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#addCourseGrade");
	}

}
