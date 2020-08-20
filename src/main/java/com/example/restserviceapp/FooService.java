package com.example.restserviceapp;

/**
 * @author Cheranev N.
 * created on 25.06.2020.
 */

import java.util.List;
import java.util.Optional;

public interface FooService {

    List<Foo> findAll();

    Integer create(Foo resource);

    void update(Integer id, Foo resource);

    Foo findById(Integer id);

    void deleteById(Integer id);
}
