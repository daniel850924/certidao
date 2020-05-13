
/**
 * SendMailServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.tempuri;

    /**
     *  SendMailServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SendMailServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SendMailServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SendMailServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for enviarEmail method
            * override this method for handling normal response from enviarEmail operation
            */
           public void receiveResultenviarEmail(
                    org.tempuri.EnviarEmailResponseDocument result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enviarEmail operation
           */
            public void receiveErrorenviarEmail(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enviarEmailComAnexo method
            * override this method for handling normal response from enviarEmailComAnexo operation
            */
           public void receiveResultenviarEmailComAnexo(
                    org.tempuri.EnviarEmailComAnexoResponseDocument result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enviarEmailComAnexo operation
           */
            public void receiveErrorenviarEmailComAnexo(java.lang.Exception e) {
            }
                


    }
    