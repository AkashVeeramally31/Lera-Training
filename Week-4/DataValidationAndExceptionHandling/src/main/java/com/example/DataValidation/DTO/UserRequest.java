package com.example.DataValidation.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "Name shouldn't be NULL")
    private String name;

    @Email(message = "Invalid email")        //Can also include message.
    private String email;

    @NotNull
    @Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile number")
    private String mobile;
    private String gender;

    @Min(20)
    @Max(50)
    private int age;

    @NotBlank       // Similar to @NotNull or @NotEmpty
    private String nationality;
}

//@Annotations used here are of the package called Validation, that is why we need the dependency of 'Validation'.

//After adding required annotations here we need to verify all the attributes in Controller class.