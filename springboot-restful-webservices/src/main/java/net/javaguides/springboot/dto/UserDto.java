package net.javaguides.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Dto = data transfer object
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    //User first name should not be null or empty
    @NotEmpty(message = "Please provide your firstname")
    private String firstName;
    @NotEmpty(message = "Please provide your lastname")
    //User lastname name should not be null or empty
    private String lastName;
    //User email should not be null or empty
    //Email address should be in valid format
    @NotEmpty(message = "Please provide an email adsdress")
    @Email(message = "Please provide a correct email address")
    private String email;
}
