package dev.marcostavares.dev_school.modules.course.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    Optional<CourseEntity> getCourses();

    Optional<CourseEntity> getCourseByName(String name);

    Optional<CourseEntity> getCoursesByCategory(String category);

}
