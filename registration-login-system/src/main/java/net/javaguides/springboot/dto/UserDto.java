package net.javaguides.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty(message = "Please provide your firstname")
    private String firstname;
    @NotEmpty(message = "Please provide your lastname")
    private String lastname;
    @NotEmpty(message = "Please provide your email address")
    @Email
    private String email;
    @NotEmpty(message = "Please provide a password")
    private String password;
}
