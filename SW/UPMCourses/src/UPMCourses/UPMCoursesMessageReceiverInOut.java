
/**
 * UPMCoursesMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package UPMCourses;

        /**
        *  UPMCoursesMessageReceiverInOut message receiver
        */

        public class UPMCoursesMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        UPMCoursesSkeleton skel = (UPMCoursesSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("checkCourse".equals(methodName)){
                
                es.upm.fi.sos.t3.practica.CheckCourseResponse checkCourseResponse9 = null;
	                        es.upm.fi.sos.t3.practica.CheckCourse wrappedParam =
                                                             (es.upm.fi.sos.t3.practica.CheckCourse)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.t3.practica.CheckCourse.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               checkCourseResponse9 =
                                                   
                                                   
                                                         skel.checkCourse(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), checkCourseResponse9, false, new javax.xml.namespace.QName("http://practica.t3.sos.fi.upm.es",
                                                    "checkCourse"));
                                    } else 

            if("showCourses".equals(methodName)){
                
                es.upm.fi.sos.t3.practica.ShowCoursesResponse showCoursesResponse11 = null;
	                        es.upm.fi.sos.t3.practica.ShowCourses wrappedParam =
                                                             (es.upm.fi.sos.t3.practica.ShowCourses)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.fi.sos.t3.practica.ShowCourses.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               showCoursesResponse11 =
                                                   
                                                   
                                                         skel.showCourses(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), showCoursesResponse11, false, new javax.xml.namespace.QName("http://practica.t3.sos.fi.upm.es",
                                                    "showCourses"));
                                    
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
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.t3.practica.CheckCourse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.t3.practica.CheckCourse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.t3.practica.CheckCourseResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.t3.practica.CheckCourseResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.t3.practica.ShowCourses param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.t3.practica.ShowCourses.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.fi.sos.t3.practica.ShowCoursesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.fi.sos.t3.practica.ShowCoursesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.practica.CheckCourseResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.practica.CheckCourseResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.t3.practica.CheckCourseResponse wrapcheckCourse(){
                                es.upm.fi.sos.t3.practica.CheckCourseResponse wrappedElement = new es.upm.fi.sos.t3.practica.CheckCourseResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.fi.sos.t3.practica.ShowCoursesResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.fi.sos.t3.practica.ShowCoursesResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.fi.sos.t3.practica.ShowCoursesResponse wrapshowCourses(){
                                es.upm.fi.sos.t3.practica.ShowCoursesResponse wrappedElement = new es.upm.fi.sos.t3.practica.ShowCoursesResponse();
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
        
                if (es.upm.fi.sos.t3.practica.CheckCourse.class.equals(type)){
                
                           return es.upm.fi.sos.t3.practica.CheckCourse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.t3.practica.CheckCourseResponse.class.equals(type)){
                
                           return es.upm.fi.sos.t3.practica.CheckCourseResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.t3.practica.ShowCourses.class.equals(type)){
                
                           return es.upm.fi.sos.t3.practica.ShowCourses.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.fi.sos.t3.practica.ShowCoursesResponse.class.equals(type)){
                
                           return es.upm.fi.sos.t3.practica.ShowCoursesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
    