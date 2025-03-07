package dev.marcostavares.dev_school.modules.course.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;
import dev.marcostavares.dev_school.modules.course.repository.CourseRepository;

@Service
public class UpdateCourse {

    @Autowired
    private CourseRepository courseRepository;

    public Optional<CourseEntity> execute(UUID id, CourseEntity courseEntity) {
        return courseRepository.findById(id).map(course -> {
            course.setName(courseEntity.getName());
            course.setCategory(courseEntity.getCategory());
            return courseRepository.save(course);
        });
    }

}
