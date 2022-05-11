package com.mySampleApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * @author fhw
 * @version 1.0
 * @date 2022-05-07 10:35
 */


public interface ObtainServiceAsync {
    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.mySampleApplication.client.ObtainService
     */
    void getDoctorListByIdOrName( java.lang.String id, AsyncCallback<java.util.List<com.mySampleApplication.client.DoctorDTO>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.mySampleApplication.client.ObtainService
     */
    void add( com.mySampleApplication.client.DoctorDTO doctorDTO, AsyncCallback<com.mySampleApplication.client.DoctorDTO> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.mySampleApplication.client.ObtainService
     */
    void delete( com.mySampleApplication.client.DoctorDTO person, AsyncCallback<java.lang.Boolean> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.mySampleApplication.client.ObtainService
     */
    void list( AsyncCallback<java.util.List<com.mySampleApplication.client.DoctorDTO>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util
    {
        private static ObtainServiceAsync instance;

        public static final ObtainServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (ObtainServiceAsync) GWT.create( ObtainService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
