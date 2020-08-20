package com.example.restserviceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Cheranev N.
 * created on 25.06.2020.
 */
@RestController
@RequestMapping("/foos")
public class FooController {

    @Autowired
    private FooService fooService;

    @GetMapping
    public List<Foo> findAll() {
        return fooService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer create(@RequestBody Foo resource) {
        return fooService.create(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Integer id, @RequestBody Foo resource) {
        fooService.update(id, resource);
    }

    @GetMapping(value = "/{id}")
    public Foo findById(@PathVariable("id") Integer id) {
        return fooService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
        fooService.deleteById(id);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public void handleResourceNotFoundException(HttpServletResponse response) {
        response.setStatus(HttpStatus.PRECONDITION_FAILED.value());
    }
}
