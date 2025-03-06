package dev.marcostavares.dev_school.modules.course;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseEntity {

    @Id
    private UUID id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String category;
    private boolean active;
    private LocalDate created_at;
    private LocalDate updated_at;

}
