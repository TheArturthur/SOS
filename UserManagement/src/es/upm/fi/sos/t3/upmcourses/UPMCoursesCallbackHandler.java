
/**
 * UPMCoursesCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package es.upm.fi.sos.t3.upmcourses;

    /**
     *  UPMCoursesCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class UPMCoursesCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public UPMCoursesCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public UPMCoursesCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for checkCourse method
            * override this method for handling normal response from checkCourse operation
            */
           public void receiveResultcheckCourse(
                    es.upm.fi.sos.t3.upmcourses.UPMCoursesStub.CheckCourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkCourse operation
           */
            public void receiveErrorcheckCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for showCourses method
            * override this method for handling normal response from showCourses operation
            */
           public void receiveResultshowCourses(
                    es.upm.fi.sos.t3.upmcourses.UPMCoursesStub.ShowCoursesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from showCourses operation
           */
            public void receiveErrorshowCourses(java.lang.Exception e) {
            }
                


    }
    