package com.example.exercice_student.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Long id;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    @Min(16)
    @Max(45)
    private Integer age;

    @Size(min = 5)
    private String email;


}
