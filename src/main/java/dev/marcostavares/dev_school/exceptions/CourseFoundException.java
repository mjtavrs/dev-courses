package dev.marcostavares.dev_school.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class CourseFoundException extends RuntimeException {
    public CourseFoundException(String courseName) {
        super("The course '" + courseName + "' already exists. Please, choose another title.");
    }
}
