package com.tutorialspoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class StaticWebController {
   @RequestMapping(value = "/staticIndex", method = RequestMethod.GET)
   public String index() {
       return "staticIndex";
   }
   @RequestMapping(value = "/staticPage", method = RequestMethod.GET)
   public String redirect() {     
      return "redirect:/pages/staticFinal.html";
   }
}
