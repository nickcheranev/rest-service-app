package com.example.restserviceapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Cheranev N.
 * created on 25.06.2020.
 */
@Service
public class FooServiceImpl implements FooService {

    private final List<Foo> foos = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();

    @Override
    public List<Foo> findAll() {
        return foos;
    }

    @Override
    public Integer create(Foo resource) {
        resource.setId(counter.incrementAndGet());
        foos.add(resource);
        return resource.getId();
    }

    @Override
    public void update(Integer id, Foo resource) {
        updateFields(resource, findById(id));
    }

    private void updateFields(Foo source, Foo target) {
        target.setName(source.getName());
    }

    @Override
    public Foo findById(Integer id) {
        Optional<Foo> optTarget = foos.stream().filter(foo -> foo.getId().equals(id)).findFirst();
        if (optTarget.isPresent()) {
            return optTarget.get();
        } else
            throw new ResourceNotFoundException();
    }

    @Override
    public void deleteById(Integer id) {
        foos.remove(findById(id));
    }
}
