package net.javaguides.springboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.UserDto;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exeption.ErrorDetails;
import net.javaguides.springboot.exeption.ResourceNotFoundException;
import net.javaguides.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name="CRUD REST APIs for user Management",
        description = "Used for creating, updating, getting modifying and deleting users"

)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    // Build create User Rest Api
    //http://localhost:8080:/api/users/add
   @Operation(
           summary = "Create User Rest Api",
           description = "This API creates a new user and saves it in a database"
   )
   @ApiResponse(
           responseCode = "201",
           description = "HTTP Status 201 Created if the user was successfully created and saved in the database"
   )
    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
       UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Build get a User Rest Api
    //http://localhost:8080:/api/users/:id
    @Operation(
            summary = "Get Single User Rest Api",
            description = "This API returns single user from the database based on id on the url"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS if the user was found"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
       UserDto user = userService.getUserById(userId);
       return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Build Get all users Rest API
    //http://localhost:8080:/api/users
    @GetMapping
    @Operation(
            summary = "Get All Users Rest Api",
            description = "This API returns all users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    public ResponseEntity<List<UserDto>> getAllUsers() {
       List<UserDto> users = userService.getAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @Operation(
            summary = "Modify user's details Api",
            description = "This API is used for modifying user's details and saving it in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS if the details of the user was successfully modified and saved in the database"
    )

//    Build update user Rest Api
//    http://localhost:8080:/api/users/update/:id
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,  @Valid @RequestBody UserDto user) {
       user.setId(userId);
       UserDto updatedUser = userService.updateUser(user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

//    Build delete user Rest Api
//    http://localhost:8080:/api/users/delete/:id
@Operation(
        summary = "Delete a User Api",
        description = "This API deletes user from the database based on id on the url"
)
@ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 SUCCESS if the user was successfully deleted from the database"
)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {
       userService.deleteUser(userId);
       return new ResponseEntity<>("The user with the id " + userId + " Successfully deleted!", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }

}
