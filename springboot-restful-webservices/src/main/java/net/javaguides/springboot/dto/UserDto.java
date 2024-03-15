package net.javaguides.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Dto = data transfer object
@Schema (
        description = "UserDto Model - describes user table in the database"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Schema (description = "Primary key. Automatically generated")
    private Long id;
    //User first name should not be null or empty
    @Schema (description = "Users first name. Should not be null or empty")
    @NotEmpty(message = "Please provide your firstname")
    private String firstName;
    @Schema (description = "User's lastname name. Should not be null or empty")
    @NotEmpty(message = "Please provide your lastname")
    //User lastname name should not be null or empty
    private String lastName;
    //User email should not be null or empty
    //Email address should be in valid format
    @Schema (description = "User's email address. Should not be null or empty, has to be in the correct format and unique")
    @NotEmpty(message = "Please provide an email adddress")
    @Email(message = "Please provide a correct email address")
    private String email;
}
