package net.javaguides.thymeleaftutorial.controller;

import net.javaguides.thymeleaftutorial.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    //handler method to handle variable-expression request
    @GetMapping("variable-expression")
    public String variableExpression(Model model) {
        User user = new User("Ali Allah", "altsu@gmail.com", "User", "other");
        model.addAttribute("user", user);
        return "variable-expression";
    }

//    method to handle selection expression
//    http://localhost:8080/selection-expression
    @GetMapping("selection-expression")
    public String selectionExpression(Model model) {
        User user = new User("Muumipeikko", "muumipeikko@muumilaakso.com","User", "We don't know");
        model.addAttribute("user", user);

        return "selection-expression";
    }

//    method to handle messeage expresssion request
    public String MessageExpression(){
        return "";
    }
}

