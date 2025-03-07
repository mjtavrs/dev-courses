package dev.marcostavares.dev_school.modules.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;
import dev.marcostavares.dev_school.modules.course.services.CreateCourse;
import dev.marcostavares.dev_school.modules.course.services.ListCourses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CreateCourse createCourse;

    @Autowired
    private ListCourses listCourses;

    @PostMapping("/")
    public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var result = this.createCourse.execute(courseEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseEntity>> getAllCourses() {
        var courses = this.listCourses.execute();
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(courses);
    }
}
