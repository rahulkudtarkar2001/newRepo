package login.logindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import login.logindemo.model.UserDtls;
import login.logindemo.service.UserService;

@Controller
public class HomeController {
@Autowired 
private UserService userService;


@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

  @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user,HttpSession session ){
      // System.out.println(user);

      boolean f = userService.checkEmail(user.getEmail());
      if(f){
       session.setAttribute("msg", "Email Id already Exists");
      }else{
        
        UserDtls userDtls= userService.createUser(user);
      if(userDtls!=null){
        session.setAttribute("msg", " Register Succesfully");
      }else{
        session.setAttribute("msg", "Something Wrong in Server database");
      }

      }

      
      return "redirect:/register";
    }

}