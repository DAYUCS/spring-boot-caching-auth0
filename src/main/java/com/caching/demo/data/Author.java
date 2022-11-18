package com.caching.demo.data;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String birthDate;

    public Author() {
    }

    public Author(
            Integer id,
            String name,
            String surname,
            String birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
}