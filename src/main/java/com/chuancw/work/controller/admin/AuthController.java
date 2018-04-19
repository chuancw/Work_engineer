package com.chuancw.work.controller.admin;

import com.chuancw.work.model.RestResponse;
import com.chuancw.work.model.WebConst;
import com.chuancw.work.model.sql_class.User;
import com.chuancw.work.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/admin")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public RestResponse login(@RequestParam String username,
                              @RequestParam String password,
                              @RequestParam(required = false) String remeber_me,
                              HttpServletRequest request,
                              HttpServletResponse response){

        try{
            User user = userService.login(username,password);
            if(null ==user){
                String msg = "login failed";
            }
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);


        }
        catch (Exception e){

        }
        return null;
    }
}
