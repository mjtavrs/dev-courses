package dev.marcostavares.dev_school.modules.course.representation;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

    private String name;
    private String category;
    private boolean active;
    private LocalDate created_at;
    private LocalDate updated_at;

}
