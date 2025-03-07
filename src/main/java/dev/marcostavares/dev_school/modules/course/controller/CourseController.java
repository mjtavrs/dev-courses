package dev.marcostavares.dev_school.modules.course.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcostavares.dev_school.modules.course.entities.CourseEntity;
import dev.marcostavares.dev_school.modules.course.services.CreateCourse;
import dev.marcostavares.dev_school.modules.course.services.DeleteCourse;
import dev.marcostavares.dev_school.modules.course.services.ListCourses;
import dev.marcostavares.dev_school.modules.course.services.UpdateCourse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CreateCourse createCourse;

    @Autowired
    private ListCourses listCourses;

    @Autowired
    private UpdateCourse updateCourse;

    @Autowired
    private DeleteCourse deleteCourse;

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

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable UUID id, @Valid @RequestBody CourseEntity courseEntity) {
        try {
            var course = this.updateCourse.execute(id, courseEntity);
            return ResponseEntity.ok().body(course);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable UUID id) {
        var course = this.deleteCourse.execute(id);
        return ResponseEntity.ok().body(course);
    }

}
