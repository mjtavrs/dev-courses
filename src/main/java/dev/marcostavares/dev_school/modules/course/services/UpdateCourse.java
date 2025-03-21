package dev.marcostavares.dev_school.modules.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.dev_school.exceptions.CourseNotFoundException;
import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;
import dev.marcostavares.dev_school.modules.course.repository.CourseRepository;
import dev.marcostavares.dev_school.modules.course.representation.CourseResponse;

@Service
public class UpdateCourse {

    @Autowired
    private CourseRepository courseRepository;

    // Maybe use @Transactional in the future?
    public CourseResponse execute(UUID id, CourseEntity courseEntity) {
        return courseRepository.findById(id).map(course -> {
            course.setName(courseEntity.getName());
            course.setCategory(courseEntity.getCategory());
            return CourseResponse.fromEntity(courseRepository.save(course));
        }).orElseThrow(CourseNotFoundException::new);
    }

}
