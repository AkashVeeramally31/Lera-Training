package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In Service");

        res.setContentType("text/html");

        //res.getWriter().println("Hello Servlet");
        //Also can be written as
        PrintWriter out=res.getWriter();
        //out.println("Hello Servlet");

        //Also we can surround it with HTML but we need to set its type as res.setContentType("text/html");
        out.println("<h2><b>Hello Servlet</b></h2>");
    }
}
