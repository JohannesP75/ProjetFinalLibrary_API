package org.library_project.api.controller;

import org.library_project.api.model.Author;
import org.library_project.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @PostMapping("")
    public Author create(@RequestBody Author obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Author get(@PathVariable("id") final Long id){
        Optional<Author> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Author> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Author update(@PathVariable("id") final Long id, @RequestBody Author body){
        Optional<Author> o=service.get(id);
        Author entity = null;

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
