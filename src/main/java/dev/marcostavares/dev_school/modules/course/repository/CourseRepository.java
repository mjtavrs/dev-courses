package dev.marcostavares.dev_school.modules.course.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    Optional<CourseEntity> findByName(String name);

    List<CourseEntity> findByCategory(String category);

}
