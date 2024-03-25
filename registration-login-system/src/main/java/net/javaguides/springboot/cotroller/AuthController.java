package net.javaguides.springboot.cotroller;

import jakarta.validation.Valid;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    //method to handle home page request
    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/register")
//    method to handle register page reguest
    public String showRegisterForm(Model model) {
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register-form";
    }

//    method to handle user registration form submit request
    @PostMapping("/register/save")
    public String saveRegistration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult, Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null) {
            bindingResult.rejectValue("email", null, "Account with the given email already exists");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register-form";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";

    }

//    method to list users
    @GetMapping("/users")
    public String users (Model model) {
        List<UserDto>
    }
}
