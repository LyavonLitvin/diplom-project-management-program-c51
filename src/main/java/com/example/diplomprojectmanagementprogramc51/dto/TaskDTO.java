package com.example.diplomprojectmanagementprogramc51.dto;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TaskDTO {


    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[0-9]*$",
            message = "ID must contain only numbers!")
    private String id;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[a-zA-Z_.]*$",
            message = "Creator name must contain only latin letters, underscores and dots!")
    private String creatorName;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[a-zA-Z_.]*$",
            message = "Executor name must contain only latin letters, underscores and dots!")
    private String executorName;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 40)
    @Pattern(regexp = "^[a-zA-Z_.]*$",
            message = "Category name must contain only latin letters, underscores and dots!")
    private String categoryName;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 40)
    @Pattern(regexp = "^[a-zA-Z_.]*$",
            message = "Status name must contain only latin letters, underscores and dots!")
    private String statusName;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 40)
    @Pattern(regexp = "^[a-zA-Z_.]*$",
            message = "Category name must contain only latin letters, underscores and dots!")
    private String name;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 250)
    @Pattern(regexp = "^[a-zA-Z_.]*$",
            message = "Description name must contain only latin letters, underscores and dots!")
    private String Description;

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 45)
    @Pattern(regexp = "^[a-zA-Z_.]*$",
            message = "Priority name must contain only latin letters, underscores and dots!")
    private String priorityName;
}


