package net.javaguides.thymeleaftutorial.controller;

import net.javaguides.thymeleaftutorial.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller


public class UserController {

    public List<User>users() {
        List<User> users = new ArrayList();
        User admin = new User ("Heltsu", "heltsun@admin.com", "admin");
        User jane = new User ("Jane", "jane@matalaguru.com", "admin");
        User yaruno = new User ("Yaruno", "yaruno@huijanen.com", "user");
        User Jonna = new User ("Jonna", "Jonna@lanttuaivo.com", "user");
        users.add(admin);
        users.add(jane);
        users.add(yaruno);
        users.add(Jonna);
        return users;
    }


    //handler method to handle variable-expression request
    @GetMapping("variable-expression")
    public String variableExpression(Model model) {
        User user = new User("Ali Allah", "altsu@gmail.com", "User");
        model.addAttribute("user", user);
        return "variable-expression";
    }

//    method to handle selection expression
//    http://localhost:8080/selection-expression
    @GetMapping("selection-expression")
    public String selectionExpression(Model model) {
        User user = new User("Muumipeikko", "muumipeikko@muumilaakso.com","User");
        model.addAttribute("user", user);

        return "selection-expression";
    }

//    method to handle messeage expresssion request
//    http://localhost:8080/message-expression
    @GetMapping("message-expression")
    public String MessageExpression(){
        return "message-expression";
    }
    // method to handle link expresssions
//    http://localhost:8080/link-expression
    @GetMapping("link-expression")
    public String LinkExpression(Model model) {
        model.addAttribute("id", 1);
        return "link-expression";
    }

    // method to handle fragments expressions
    //    http://localhost:8080/fragment-expression
    @GetMapping("fragment-expression")
    public String FragmentExpression() {
        return "fragment-expression";
    }

    @GetMapping("user-list")
    public String userList(Model model) {

        model.addAttribute("users", users());
        return "user-list";

    }

    @GetMapping("if-unless")
    public String ifUnless(Model model) {

        model.addAttribute("users", users());
        return "if-unless";
    }

    @GetMapping("switch-case")
    public String switchCase(Model model) {
        User admin = new User ("Heltsu", "heltsun@admin.com", "admin");
        model.addAttribute("user", admin);
        return "switch-case";
    }



}

