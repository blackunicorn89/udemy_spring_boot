package net.javaguides.thymeleaftutorial.controller;

import net.javaguides.thymeleaftutorial.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {
    @GetMapping("register")
    public String userRegistrationPage(Model model) {

        //Empty UserForm model object to store form data
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        List<String>listProfession = Arrays.asList("Developer", "Tester", "Architect", "Other");
        model.addAttribute("listProfession", listProfession);

        return "register-user";
    }

//    method to handle user registration page request

}
