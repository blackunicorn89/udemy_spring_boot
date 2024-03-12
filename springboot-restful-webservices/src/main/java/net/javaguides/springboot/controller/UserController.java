package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    // Build create User Rest Api
    //http://localhost:8080:/api/users/add
   @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Build get User Rest Api
    //http://localhost:8080:/api/users/:id
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
       User user = userService.getUserById(userId);
       return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Build Get all users Rest API
    //http://localhost:8080:/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
       List<User> users = userService.getAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    Build update user Rest Api
//    http://localhost:8080:/api/users/update/:id
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,  @RequestBody User user) {
       user.setId(userId);
       User updatedUser = userService.updateUser(user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

//    Build delete user Rest Api
//    http://localhost:8080:/api/users/delete/:id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {
       userService.deleteUser(userId);
       return new ResponseEntity<>("The user with the id " + userId + " Successfully deleted!", HttpStatus.OK);
    }

}
