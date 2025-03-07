package dev.marcostavares.dev_school.modules.course.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {

    private String name;
    private String category;
    private boolean active;
    private LocalDate created_at;
    private LocalDate updated_at;

}
