package com.caching.demo.controllers;

import com.caching.demo.data.Author;
import com.caching.demo.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ChronoUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Integer id) {
        loggingMessage("Request received!");
        // retrieving the desired data
        Author author = authorService.retrieveById(id);
        loggingMessage("Data retrieved!");

        return new ResponseEntity<>(
                author,
                HttpStatus.OK
        );
    }

    private void loggingMessage(
            String message
    ) {
        System.out.printf("[%s] %s%n", java.time.LocalTime.now().truncatedTo(ChronoUnit.MILLIS), message);
    }
}
