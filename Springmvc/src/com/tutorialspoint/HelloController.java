package com.tutorialspoint;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.jdbc.test;

import org.springframework.ui.ModelMap;
@Controller
@RequestMapping("/hello")
public class HelloController{
	@Autowired
	private test Test;
	
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) throws SQLException {
	   Test.handler();
	   
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
}
