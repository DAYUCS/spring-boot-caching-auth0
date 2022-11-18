package com.caching.demo.services;

import com.caching.demo.data.Author;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Cacheable("authors")
    public Author retrieveById(Integer id) {
        // simulating a delay due to the data retrieval operation
        try {
            System.out.println("Retrieving the author...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // returning a list containing all the authors
        return new Author(id, "Mary", "Williams", "1988-11-19");
    }
}
