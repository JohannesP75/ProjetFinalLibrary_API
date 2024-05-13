package org.library_project.api.controller;

import org.library_project.api.model.Dewey;
import org.library_project.api.service.DeweyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("dewey")
public class DeweyController {
    @Autowired
    private DeweyService service;

    @PostMapping("")
    public Dewey create(@RequestBody Dewey obj){
        return service.save(obj);
    }

    @GetMapping("/{id}")
    public Dewey get(@PathVariable("id") final Long id){
        Optional<Dewey> obj=service.get(id);

        return obj.orElse(null);
    }

    @GetMapping("")
    public Iterable<Dewey> getAll(){
        return service.getAll();
    }

    @PatchMapping("/{id}")
    public Dewey update(@PathVariable("id") final Long id, @RequestBody Dewey body){
        Optional<Dewey> o=service.get(id);
        Dewey entity=null;

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