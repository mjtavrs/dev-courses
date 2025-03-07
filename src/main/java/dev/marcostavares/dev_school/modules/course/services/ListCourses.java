package dev.marcostavares.dev_school.modules.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;
import dev.marcostavares.dev_school.modules.course.repository.CourseRepository;

@Service
public class ListCourses {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        List<CourseEntity> courses = courseRepository.findAll();
        return courses;
    }

}
