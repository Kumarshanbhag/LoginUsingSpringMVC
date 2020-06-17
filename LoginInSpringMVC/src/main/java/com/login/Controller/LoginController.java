package com.login.Controller;

import com.login.Model.User;
import com.login.Services.LoginService;
import com.login.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @GetMapping("/")
    public String index(Model m) {
//        m.addAttribute("someAttribute", "someValue");
        System.out.println("Main");
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("Login Redirect");
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView Login(@RequestParam("name") String username, @RequestParam("password") String password) {
        System.out.println("Login Click");
        ModelAndView mv = new ModelAndView();
        User user = loginService.logincheck(username, password);
        if (user != null) {
            mv.addObject("user", user);
            mv.setViewName("welcome");
            return mv;
            //return "welcome";
        }
        mv.addObject("error", "Invalid Details");
        mv.setViewName("login");
        return mv;
//        return "login";
    }

    @GetMapping("/register")
    public String register() {
        System.out.println("Register Redirect");
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam("name") String username, @RequestParam("address") String address,
                                 @RequestParam("password") String password, @RequestParam("email") String email) {

        System.out.println("RegisterClick");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername(username);
        user.setAddress(address);
        user.setEmail(email);
        user.setPassword(password);
        String errorMessage = null;
        errorMessage = registerService.check(user);
        if (errorMessage == null) {
            mv.addObject("user", user);
            mv.setViewName("login");
            return mv;
        }
        mv.addObject("error", errorMessage);
        mv.setViewName("register");
        return mv;
    }
}
