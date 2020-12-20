
package com.webservices.restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")//Req came from servlet container from web.xml to @path
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET // BY default all req are GET
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
}
