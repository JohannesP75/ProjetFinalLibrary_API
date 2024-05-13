package org.library_project.api.controller;

import org.library_project.api.model.Book;
import org.library_project.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService service;

    @PostMapping("")
    public Book create(@RequestBody Book obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable("id") final Long id){
        Optional<Book> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Book> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Book update(@PathVariable("id") final Long id, @RequestBody Book body){
        Optional<Book> o=service.get(id);
        Book entity=null;

        if(o.isPresent()){
            entity=o.get();
        }

        return entity;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final Long id){
        service.delete(id);
    }
}
