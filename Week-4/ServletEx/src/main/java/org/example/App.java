package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        Tomcat tc=new Tomcat();

        Context con=tc.addContext("",null);
        Tomcat.addServlet(con,"h1",new HelloServlet());
        con.addServletMappingDecoded("/hello","h1");

        tc.start();
        tc.getServer().await();
    }
}
