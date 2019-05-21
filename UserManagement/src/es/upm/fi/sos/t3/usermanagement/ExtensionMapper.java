
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package es.upm.fi.sos.t3.usermanagement;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://usermanagement.t3.sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "PasswordPair".equals(typeName)){
                   
                            return  es.upm.fi.sos.t3.usermanagement.xsd.PasswordPair.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://usermanagement.t3.sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "User".equals(typeName)){
                   
                            return  es.upm.fi.sos.t3.usermanagement.xsd.User.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://usermanagement.t3.sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "Response".equals(typeName)){
                   
                            return  es.upm.fi.sos.t3.usermanagement.xsd.Response.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://usermanagement.t3.sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "GradesResponse".equals(typeName)){
                   
                            return  es.upm.fi.sos.t3.usermanagement.xsd.GradesResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://usermanagement.t3.sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "Username".equals(typeName)){
                   
                            return  es.upm.fi.sos.t3.usermanagement.xsd.Username.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://usermanagement.t3.sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "CourseGrade".equals(typeName)){
                   
                            return  es.upm.fi.sos.t3.usermanagement.xsd.CourseGrade.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://usermanagement.t3.sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "CourseResponse".equals(typeName)){
                   
                            return  es.upm.fi.sos.t3.usermanagement.xsd.CourseResponse.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://usermanagement.t3.sos.fi.upm.es/xsd".equals(namespaceURI) &&
                  "Course".equals(typeName)){
                   
                            return  es.upm.fi.sos.t3.usermanagement.xsd.Course.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    