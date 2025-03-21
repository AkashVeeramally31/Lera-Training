package com.example.SpringWebUsingJSP;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        //System.out.println("Method called");
        return "index.jsp";
    }

    //Using servlet to retrieve the data
//    @RequestMapping("add")
//    public String add(HttpServletRequest req, HttpSession session) {
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int result = num1 + num2;
//        session.setAttribute("result",result);
//        return "result.jsp";
//    }

    //Using spring framework i.e.., @RequestParam method.
//    @RequestMapping("add")
//    public String add(@RequestParam int num1,@RequestParam int num2,HttpSession session) {
//        int result = num1 + num2;
//        session.setAttribute("result",result);
//        return "result.jsp";
//    }

    //Optimizing by Removing HttpSession object using Model interface which is used transfer one type of object to
    // another for example controller and jsp.
//    @RequestMapping("add")
//    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
//        int result = num1 + num2;
//        model.addAttribute("result",result);
//        return "result.jsp";
//    }

    //Using ModelAndView class
    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv) {
        int result = num1 + num2;
        mv.addObject("result",result);
        mv.setViewName("result.jsp");
        return mv;
    }
}


//In result.jsp:-
//<h2>Result is:<%= session.getAttribute("result") %></h2>
//The above statement can also written as:
//<h2>Result is: ${result}  </h2>