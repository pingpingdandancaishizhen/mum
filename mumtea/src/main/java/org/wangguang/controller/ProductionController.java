package org.wangguang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangguang.entity.Production;
import org.wangguang.entity.User;
import org.wangguang.service.ProductionService;

@Controller
@RequestMapping("/production")
public class ProductionController {


    @Autowired
    private	ProductionService productionService;

    

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable Long id,HttpServletRequest req) {
        // userService.save(user);
        Production p = productionService.findById(id);
        req.setAttribute("p", p);
        return "production/detail";
    }
    
    

}