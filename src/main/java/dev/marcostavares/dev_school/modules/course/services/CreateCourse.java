package dev.marcostavares.dev_school.modules.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.dev_school.exceptions.CourseFoundException;
import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;
import dev.marcostavares.dev_school.modules.course.repository.CourseRepository;

@Service
public class CreateCourse {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository
                .getCourseByName(courseEntity.getName())
                .ifPresent(course -> {
                    throw new CourseFoundException();
                });

        return this.courseRepository.save(courseEntity);
    }

}
