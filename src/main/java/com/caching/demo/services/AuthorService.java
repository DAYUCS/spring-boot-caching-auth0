package com.caching.demo.services;

import com.caching.demo.data.Author;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private ConcurrentHashMap<Integer, Author> store = new ConcurrentHashMap<>();

    @Cacheable("authors")
    public Author retrieveById(Integer id) {
        // simulating a delay due to the data retrieval operation
        try {
            System.out.println("Retrieving the author...");
            store.put(id, new Author(id, "Mary", "Williams", "1988-11-19"));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return store.get(id);
    }

    @CachePut("authors")
    public Author replaceById(Integer id) {
        store.replace(id, new Author(id, "Tom", "Williams", "1978-11-19"));
        return store.get(id);
    }
}
