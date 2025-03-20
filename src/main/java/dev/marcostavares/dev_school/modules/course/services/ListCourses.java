package dev.marcostavares.dev_school.modules.course.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.dev_school.exceptions.NoCoursesException;
import dev.marcostavares.dev_school.modules.course.repository.CourseRepository;
import dev.marcostavares.dev_school.modules.course.representation.CourseResponse;

@Service
public class ListCourses {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseResponse> execute() {
        var courses = courseRepository.findAll()
                .stream()
                .map(CourseResponse::fromEntity)
                .collect(Collectors.toList());

        if (courses.isEmpty()) {
            throw new NoCoursesException();
        } else {
            return courses;
        }

    }

}
