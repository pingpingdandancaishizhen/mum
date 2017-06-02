package org.wangguang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangguang.entity.User;
import org.wangguang.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    public static void main(String[] args) {
        /*
         * ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
         * UserService beanA = (UserService) context.getBean("UserServiceImpl");
         */
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/getMes")
    public String getMes() {

        return "userShow";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(User user) {
        // userService.save(user);
        //userService.findByName(user.getName());
        return "userShow";
    }

}