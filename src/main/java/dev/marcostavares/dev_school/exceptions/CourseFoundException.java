package dev.marcostavares.dev_school.exceptions;

public class CourseFoundException extends RuntimeException {
    public CourseFoundException() {
        super("This course already exists.");
    }
}
