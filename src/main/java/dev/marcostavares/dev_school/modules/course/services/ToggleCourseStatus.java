package dev.marcostavares.dev_school.modules.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;
import dev.marcostavares.dev_school.modules.course.repository.CourseRepository;

@Service
public class ToggleCourseStatus {

    @Autowired
    private CourseRepository courseRepository;

    public String execute(UUID id, CourseEntity courseEntity) {
        this.courseRepository.findById(id).map(course -> {
            course.setActive(courseEntity.isActive());
            return courseRepository.save(course);
        });

        return "Course status toggled";
    }

}
