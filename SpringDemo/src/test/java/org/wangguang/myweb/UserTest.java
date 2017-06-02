package org.wangguang.myweb;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wangguang.entity.User;
import org.wangguang.service.UserService;

public class UserTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        final UserService userDAO = ctx.getBean(UserService.class);
        User u = new User();
        u.setAge(12);
        u.setDatetime(new Date());
        u.setName("11");
        userDAO.save(u);
        System.out.println("ddd");

    }

}
