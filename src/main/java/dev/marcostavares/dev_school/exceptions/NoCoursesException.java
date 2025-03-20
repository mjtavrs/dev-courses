package dev.marcostavares.dev_school.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoCoursesException extends RuntimeException {
    public NoCoursesException() {
        super("There are no courses in our database.");
    }
}
