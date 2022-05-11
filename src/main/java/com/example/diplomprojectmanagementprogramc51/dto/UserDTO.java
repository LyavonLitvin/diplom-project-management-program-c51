package com.example.diplomprojectmanagementprogramc51.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    private static final String MSG_NAME_EMPTY = "name empty";
    private static final String MSG_PASSWORD_EMPTY = "password empty";

    @NotBlank
    @NotEmpty
//    @Pattern(regexp = "^[0-9]*$",
//            message = "ID must contain only numbers!")
    private long id;

    @NotNull(message = MSG_NAME_EMPTY)
    @Size(min = 3, max = 50)
    private String username; // Логин пользователя

//    @NotNull(message = MSG_PASSWORD_EMPTY)
//    private String password;

//    private String firstName;
//    private String lastName;
//
//    @NotNull
//    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
//    private String email;

}
