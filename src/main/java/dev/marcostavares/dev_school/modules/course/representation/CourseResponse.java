package dev.marcostavares.dev_school.modules.course.representation;

import java.time.LocalDate;
import java.util.UUID;

import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;
import dev.marcostavares.dev_school.modules.course.enums.CourseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

    private UUID id;
    private String name;
    private String category;
    private boolean active;
    private LocalDate created_at;
    private LocalDate updated_at;

    public static CourseResponse fromEntity(CourseEntity courseEntity) {
        return CourseResponse.builder()
                .id(courseEntity.getId())
                .name(courseEntity.getName())
                .category(courseEntity.getCategory())
                .active(courseEntity.getActive() == CourseStatusEnum.ACTIVE)
                .created_at(courseEntity.getCreated_at())
                .updated_at(courseEntity.getUpdated_at())
                .build();
    }

}
