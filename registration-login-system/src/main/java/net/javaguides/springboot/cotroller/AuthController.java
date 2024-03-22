package net.javaguides.springboot.cotroller;

import net.javaguides.springboot.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    //method to handle home page request
    @GetMapping("index")
    public String homePage() {
        return "index";
    }

    @GetMapping("register")
//    method to handle register page reguest
    public String showRegisterForm(Model model) {
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register-form";
    }
}
