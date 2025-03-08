package dev.marcostavares.dev_school.modules.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.dev_school.modules.course.enums.CourseStatusEnum;
import dev.marcostavares.dev_school.modules.course.repository.CourseRepository;

@Service
public class ToggleCourseStatus {

    @Autowired
    private CourseRepository courseRepository;

    public String execute(UUID id) {
        return courseRepository.findById(id).map(course -> {
            course.setActive(course.getActive() == CourseStatusEnum.ACTIVE ? CourseStatusEnum.INACTIVE
                    : CourseStatusEnum.ACTIVE);
            courseRepository.save(course);
            return "Course status toggled";
        }).orElse("Course not found");
    }

}
