package org.library_project.api.controller;

import org.library_project.api.model.Reader;
import org.library_project.api.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("readers")
public class ReaderController {
    @Autowired
    private ReaderService service;

    @PostMapping("")
    public Reader create(@RequestBody Reader obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Reader get(@PathVariable("id") final Long id){
        Optional<Reader> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Reader> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Reader update(@PathVariable("id") final Long id, @RequestBody Reader body){
        Optional<Reader> o=service.get(id);
        Reader entity=null;

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