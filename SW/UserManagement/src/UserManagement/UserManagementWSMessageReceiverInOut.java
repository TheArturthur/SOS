
/**
 * UserManagementWSMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package UserManagement;

/**
 *  UserManagementWSMessageReceiverInOut message receiver
 */

public class UserManagementWSMessageReceiverInOut extends 
org.apache.axis2.receivers.AbstractInOutMessageReceiver{


	public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, 
			org.apache.axis2.context.MessageContext newMsgContext) throws org.apache.axis2.AxisFault{

		try {

			// get the implementation class for the Web Service
			Object obj = getTheImplementationObject(msgContext);

			UserManagementWSSkeleton skel = (UserManagementWSSkeleton)obj;
			//Out Envelop
			org.apache.axiom.soap.SOAPEnvelope envelope = null;
			//Find the axisOperation that has been set by the Dispatch phase.
			org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
			if (op == null) {
				throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
			}

			java.lang.String methodName;
			if((op.getName() != null) && 
					((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){




				if("changePassword".equals(methodName)){

					es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse changePasswordResponse32 = null;
					es.upm.fi.sos.t3.usermanagement.ChangePassword wrappedParam =
							(es.upm.fi.sos.t3.usermanagement.ChangePassword)fromOM(
									msgContext.getEnvelope().getBody().getFirstElement(),
									es.upm.fi.sos.t3.usermanagement.ChangePassword.class,
									getEnvelopeNamespaces(msgContext.getEnvelope()));

					changePasswordResponse32 = skel.changePassword(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext),
							changePasswordResponse32,
							false,
							new javax.xml.namespace.QName("http://usermanagement.t3.sos.fi.upm.es", "changePassword"));
				} else if("login".equals(methodName)){
					es.upm.fi.sos.t3.usermanagement.LoginResponse loginResponse34 = null;
					es.upm.fi.sos.t3.usermanagement.Login wrappedParam =
							(es.upm.fi.sos.t3.usermanagement.Login)fromOM(
									msgContext.getEnvelope().getBody().getFirstElement(),
									es.upm.fi.sos.t3.usermanagement.Login.class,
									getEnvelopeNamespaces(msgContext.getEnvelope()));

					loginResponse34 = skel.login(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext),
							loginResponse34,
							false,
							new javax.xml.namespace.QName("http://usermanagement.t3.sos.fi.upm.es", "login"));
				} else if("showCourses".equals(methodName)){
					es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse showCoursesResponse36 = null;
					es.upm.fi.sos.t3.usermanagement.ShowCourses wrappedParam =
							(es.upm.fi.sos.t3.usermanagement.ShowCourses)fromOM(
									msgContext.getEnvelope().getBody().getFirstElement(),
									es.upm.fi.sos.t3.usermanagement.ShowCourses.class,
									getEnvelopeNamespaces(msgContext.getEnvelope()));

					showCoursesResponse36 = skel.showCourses(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext),
							showCoursesResponse36,
							false,
							new javax.xml.namespace.QName("http://usermanagement.t3.sos.fi.upm.es", "showCourses"));
				} else if("showAllGrades".equals(methodName)){
					es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse showAllGradesResponse38 = null;
					es.upm.fi.sos.t3.usermanagement.ShowAllGrades wrappedParam =
							(es.upm.fi.sos.t3.usermanagement.ShowAllGrades)fromOM(
									msgContext.getEnvelope().getBody().getFirstElement(),
									es.upm.fi.sos.t3.usermanagement.ShowAllGrades.class,
									getEnvelopeNamespaces(msgContext.getEnvelope()));

					showAllGradesResponse38 = skel.showAllGrades(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext), 
							showAllGradesResponse38, 
							false, 
							new javax.xml.namespace.QName("http://usermanagement.t3.sos.fi.upm.es", "showAllGrades"));
				} else if("addUser".equals(methodName)){
					es.upm.fi.sos.t3.usermanagement.AddUserResponse addUserResponse40 = null;
					es.upm.fi.sos.t3.usermanagement.AddUser wrappedParam =
							(es.upm.fi.sos.t3.usermanagement.AddUser)fromOM(
									msgContext.getEnvelope().getBody().getFirstElement(),
									es.upm.fi.sos.t3.usermanagement.AddUser.class,
									getEnvelopeNamespaces(msgContext.getEnvelope()));

					addUserResponse40 = skel.addUser(wrappedParam);

					envelope = toEnvelope(getSOAPFactory(msgContext),
							addUserResponse40, 
							false, 
							new javax.xml.namespace.QName("http://usermanagement.t3.sos.fi.upm.es",	"addUser"));
				} else if("removeUser".equals(methodName)){
						es.upm.fi.sos.t3.usermanagement.RemoveUserResponse removeUserResponse42 = null;
						es.upm.fi.sos.t3.usermanagement.RemoveUser wrappedParam =
								(es.upm.fi.sos.t3.usermanagement.RemoveUser)fromOM(
										msgContext.getEnvelope().getBody().getFirstElement(),
										es.upm.fi.sos.t3.usermanagement.RemoveUser.class,
										getEnvelopeNamespaces(msgContext.getEnvelope()));

						removeUserResponse42 = skel.removeUser(wrappedParam);

						envelope = toEnvelope(getSOAPFactory(msgContext),
								removeUserResponse42,
								false,
								new javax.xml.namespace.QName("http://usermanagement.t3.sos.fi.upm.es",	"removeUser"));
					} else if("addCourseGrade".equals(methodName)){
							es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse addCourseGradeResponse44 = null;
							es.upm.fi.sos.t3.usermanagement.AddCourseGrade wrappedParam =
									(es.upm.fi.sos.t3.usermanagement.AddCourseGrade)fromOM(
											msgContext.getEnvelope().getBody().getFirstElement(),
											es.upm.fi.sos.t3.usermanagement.AddCourseGrade.class,
											getEnvelopeNamespaces(msgContext.getEnvelope()));

							addCourseGradeResponse44 = skel.addCourseGrade(wrappedParam);

							envelope = toEnvelope(getSOAPFactory(msgContext),
									addCourseGradeResponse44,
									false,
									new javax.xml.namespace.QName("http://usermanagement.t3.sos.fi.upm.es",	"addCourseGrade"));

						} else {
							throw new java.lang.RuntimeException("method not found");
						}

				newMsgContext.setEnvelope(envelope);
			}
		}
		catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	//
	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.ChangePassword param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.ChangePassword.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.Login param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.Login.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.LoginResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.LoginResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.Logout param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.Logout.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.ShowCourses param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.ShowCourses.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.ShowAllGrades param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.ShowAllGrades.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.AddUser param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.AddUser.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.AddUserResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.AddUserResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.RemoveUser param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.RemoveUser.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.RemoveUserResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.RemoveUserResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.AddCourseGrade param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.AddCourseGrade.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.om.OMElement toOM(es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse param, boolean optimizeContent)
			throws org.apache.axis2.AxisFault {


		try{
			return param.getOMElement(es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse.MY_QNAME,
					org.apache.axiom.om.OMAbstractFactory.getOMFactory());
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}


	}

	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{
		try{
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse.MY_QNAME,factory));


			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse wrapchangePassword(){
		es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse wrappedElement = new es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse();
		return wrappedElement;
	}

	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.usermanagement.LoginResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{
		try{
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.usermanagement.LoginResponse.MY_QNAME,factory));


			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private es.upm.fi.sos.t3.usermanagement.LoginResponse wraplogin(){
		es.upm.fi.sos.t3.usermanagement.LoginResponse wrappedElement = new es.upm.fi.sos.t3.usermanagement.LoginResponse();
		return wrappedElement;
	}

	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{
		try{
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse.MY_QNAME,factory));


			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse wrapshowCourses(){
		es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse wrappedElement = new es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse();
		return wrappedElement;
	}

	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{
		try{
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse.MY_QNAME,factory));


			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse wrapshowAllGrades(){
		es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse wrappedElement = new es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse();
		return wrappedElement;
	}

	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.usermanagement.AddUserResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{
		try{
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.usermanagement.AddUserResponse.MY_QNAME,factory));


			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private es.upm.fi.sos.t3.usermanagement.AddUserResponse wrapaddUser(){
		es.upm.fi.sos.t3.usermanagement.AddUserResponse wrappedElement = new es.upm.fi.sos.t3.usermanagement.AddUserResponse();
		return wrappedElement;
	}

	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.usermanagement.RemoveUserResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{
		try{
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.usermanagement.RemoveUserResponse.MY_QNAME,factory));


			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private es.upm.fi.sos.t3.usermanagement.RemoveUserResponse wrapremoveUser(){
		es.upm.fi.sos.t3.usermanagement.RemoveUserResponse wrappedElement = new es.upm.fi.sos.t3.usermanagement.RemoveUserResponse();
		return wrappedElement;
	}

	private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
			throws org.apache.axis2.AxisFault{
		try{
			org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

			emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse.MY_QNAME,factory));


			return emptyEnvelope;
		} catch(org.apache.axis2.databinding.ADBException e){
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
	}

	private es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse wrapaddCourseGrade(){
		es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse wrappedElement = new es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse();
		return wrappedElement;
	}



	/**
	 *  get the default envelope
	 */
	private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
		return factory.getDefaultEnvelope();
	}


	private  java.lang.Object fromOM(
			org.apache.axiom.om.OMElement param,
			java.lang.Class type,
			java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

		try {

			if (es.upm.fi.sos.t3.usermanagement.ChangePassword.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.ChangePassword.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.ChangePasswordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.Login.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.Login.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.LoginResponse.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.LoginResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.Logout.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.Logout.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.ShowCourses.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.ShowCourses.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.ShowCoursesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.ShowAllGrades.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.ShowAllGrades.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.ShowAllGradesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.AddUser.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.AddUser.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.AddUserResponse.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.AddUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.RemoveUser.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.RemoveUser.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.RemoveUserResponse.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.RemoveUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.AddCourseGrade.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.AddCourseGrade.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

			if (es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse.class.equals(type)){

				return es.upm.fi.sos.t3.usermanagement.AddCourseGradeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


			}

		} catch (java.lang.Exception e) {
			throw org.apache.axis2.AxisFault.makeFault(e);
		}
		return null;
	}





	/**
	 *  A utility method that copies the namepaces from the SOAPEnvelope
	 */
	private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
		java.util.Map returnMap = new java.util.HashMap();
		java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
			returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
		}
		return returnMap;
	}

	private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
		org.apache.axis2.AxisFault f;
		Throwable cause = e.getCause();
		if (cause != null) {
			f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
		} else {
			f = new org.apache.axis2.AxisFault(e.getMessage());
		}

		return f;
	}

}//end of class
