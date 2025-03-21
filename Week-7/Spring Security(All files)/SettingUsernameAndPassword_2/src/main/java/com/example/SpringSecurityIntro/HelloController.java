
// We create a 'HelloController' to redirect to this page.
// For this url is:- http://localhost:8080/hello
// When we open this url, by default we get the login page because we are using spring security.
// So after giving the correct credentials, we are redirected to 'hello' page giving the output.
// For every login, you must also logout otherwise accessing a second time will give an error.

// When we login the application for the first time, we can access any number of controllers (or) pages
// before the logout of the session because the browser stores our session id, and it automatically opens
// the application without even taking credentials again.

// For example, Gmail: - when we login for the first time and if we are trying to login again then
// it will not ask any credentials, it will redirect to Gmail.


package com.example.SpringSecurityIntro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String get(){
        return "Hello World!";
    }

    @GetMapping("about")
    public String getA(){
        return "About page..";
    }
}
