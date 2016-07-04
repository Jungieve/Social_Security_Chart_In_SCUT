package org.scut.mychart.controller;

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import org.scut.mychart.model.AC01;  
import org.scut.mychart.service.IUserService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/showUser")
    @ResponseBody
    public String toIndex(HttpServletRequest request,Model model){  
        String userId = String.valueOf(request.getParameter("id"));  
        AC01 ac01 = this.userService.getAC01ById(userId);  
        model.addAttribute("user", ac01);  
        return "showUser";  
    }  
}  
