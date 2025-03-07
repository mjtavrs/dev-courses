package dev.marcostavares.dev_school.modules.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.dev_school.modules.course.repository.CourseRepository;

@Service
public class DeleteCourse {

    @Autowired
    private CourseRepository courseRepository;

    public String execute(UUID id) {
        courseRepository.deleteById(id);
        return "Course successfully deleted";
    }

}
